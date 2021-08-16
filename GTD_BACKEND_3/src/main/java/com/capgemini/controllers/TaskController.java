package com.capgemini.controllers;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.WebSecurityConfig;
import com.capgemini.model.Propietario;
import com.capgemini.model.Tasks;
import com.capgemini.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private HttpSession httpSession;

	@Autowired
	TaskService service;

	@Autowired
	WebSecurityConfig config;

	@GetMapping("/listTasks/{id}")
	public ResponseEntity<List<Tasks>> listTasks(@PathVariable Long id, @RequestParam boolean pastDate){
		//		if(!router(httpSession))
		//			return new ArrayList<Tasks>();
		if(!config.authRouter(httpSession))
			return new ResponseEntity<List<Tasks>>(HttpStatus.FORBIDDEN);
		Long propietarioId = 1L;
		if(router(httpSession))
			propietarioId = activeUserRouter(httpSession);

		return new ResponseEntity<List<Tasks>>(service.listTasks(id, propietarioId ,pastDate), HttpStatus.ACCEPTED); 
	}

	@PutMapping("/editTask/{id}")
	public ResponseEntity<Tasks> editTasks(@RequestAttribute Long id, @RequestBody Tasks tasks){
		if(!config.authRouter(httpSession))
			return new ResponseEntity<Tasks>(HttpStatus.FORBIDDEN);
		tasks.setId(id);
		if(tasks.getPlanned().getTime() <= (new Date(System.currentTimeMillis())).getTime())
			tasks.setPlanned(new java.util.Date());

		try {
			return new ResponseEntity<Tasks>(service.save(tasks), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Tasks>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping("/addTask")
	public ResponseEntity<Tasks> addTasks( @RequestBody Tasks tasks){
		if(!config.authRouter(httpSession))
			return new ResponseEntity<Tasks>(HttpStatus.FORBIDDEN);
		//Mirad que exista el id y que si es de usuario concuerde con la sesion y si es grupo lo tenga el usuario
		Tasks t = new Tasks();
		t.setCategory(null);
		t.setCreated(new Date(System.currentTimeMillis()));
		t.setTitle(tasks.getTitle());
		//if(router(httpSession))
		t.setPropietario(new Propietario(activeUserRouter(httpSession), null));

		try {
			return new ResponseEntity<Tasks>(service.save(t), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Tasks>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PutMapping("/finishTask/{id}")
	public ResponseEntity<Tasks> editTasks(@PathVariable Long id){
		if(!config.authRouter(httpSession))
			return new ResponseEntity<Tasks>(HttpStatus.FORBIDDEN);
		Tasks t = service.findById(id);
		t.setFinished(new Date(System.currentTimeMillis()));
		try {
			return new ResponseEntity<Tasks>(service.save(t), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Tasks>(HttpStatus.INTERNAL_SERVER_ERROR);
	}


	private boolean router(HttpSession session) {

		if(session== null)
			return false;
		Long sessionId = (Long) session.getAttribute("usuario");
		if(sessionId== null) 
			return false;

		else
			return true;
	}

	private Long activeUserRouter(HttpSession session) {

		if(router(session))
			return (long) session.getAttribute("usuario");
		else
			return 1L;
	}
}

package com.capgemini.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.Tasks;
import com.capgemini.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	TaskService service;
	
	@GetMapping("/listTasks/{id}")
	public List<Tasks> listTasks(@RequestAttribute Long id, @RequestParam boolean pastDate){
		return service.listTasks(id, pastDate);
	}
	
	@PutMapping("/editTask/{id}")
	public Tasks editTasks(@RequestAttribute Long id, @RequestBody Tasks tasks){
		tasks.setId(id);
		try {
			return service.save(tasks);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tasks;
	}
	
	@PostMapping("/addTask")
	public Tasks addTasks( @RequestBody Tasks tasks){
		
		try {
			tasks.setCreated(new Date(System.currentTimeMillis()));
			return service.save(tasks);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping("/finishTask/{id}")
	public Tasks editTasks(@RequestAttribute Long id){
		Tasks t = service.findById(id);
		t.setFinished(new Date(System.currentTimeMillis()));
		try {
			return service.save(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

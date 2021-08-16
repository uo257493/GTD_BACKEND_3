package com.capgemini.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.GroupUsers;
import com.capgemini.model.Groups;
import com.capgemini.model.Propietario;
import com.capgemini.model.Users;
import com.capgemini.model.DTO.PropietarioDTO;
import com.capgemini.model.DTO.PropietarioMapper;
import com.capgemini.repositories.PropietarioRepository;
import com.capgemini.repositories.UserRepository;
import com.capgemini.service.GroupService;
import com.capgemini.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserRepository ur;

	@Autowired
	PropietarioRepository pr;

	@Autowired
	UserService us;
	
	@Autowired
	GroupService gs;

	/**
	 * add user if usser it's a group, add group too
	 * 
	 * @param propietario
	 * @return
	 */
	@PostMapping("/add")
	public Propietario addPropietario(@RequestBody PropietarioDTO propietario) {

		Propietario tr = pr.save(PropietarioMapper.executed(propietario));
		// Users us1 = us.getUserByid(session.getUsuario);
		Users us1 = new Users();
		us1.setId((long) 5);
		// us1.setId(us1.getId().MAX_VALUE+1);
		if (propietario.type.equals("grupo")) {
			us.save(new GroupUsers((Integer.parseInt(tr.getId() + "")), true, true, us1, (Groups) tr));
			return tr;
		} else {

		}
		return us1;

		// return pr.save(PropietarioMapper.executed(propietario));
	}

	/**
	 * add group
	 * 
	 * @param propietario
	 * @return
	 */

	@PostMapping("/addgroup")
	public Propietario addGroup(@RequestBody PropietarioDTO propietario) {

		return pr.save(PropietarioMapper.execu(propietario));
	}

	/**
	 * delete user and everything of that user for system
	 * 
	 * @param id
	 * @return
	 */

	@DeleteMapping("deleteusers/{id}")
	public String deteteUsers(@PathVariable Long id) {

		Optional<Propietario> propietario = pr.findById(id);

		if (propietario == null) {
			throw new RuntimeException("Id del propietario no encontrado -" + id);
		}

		pr.deleteById(id);

		return "Eliminado propietario id - " + id;
	}

	/**
	 * delete user for system
	 * 
	 * @param id
	 * @return
	 */

	@DeleteMapping("deleteonlyUser/{id}")
	public String deleteUser(@PathVariable Long id) {

		Optional<Users> propietario = us.findById(id);

		if (propietario == null) {
			throw new RuntimeException("Id del propietario no encontrado -" + id);
		}

		us.deleteById(id);

		return "Eliminado propietario id - " + id;
	}
	// eliminar grupo
	@DeleteMapping("deletegroup/{id}")
	public String deletegroup(@PathVariable Long id) {

		Optional<Groups> propietario = gs.findById(id);

		if (propietario == null) {
			throw new RuntimeException("Id del propietario no encontrado -" + id);
		}

		gs.deleteById(id);

		return "Eliminado propietario id - " + id;
	}
	

	/**
	 * find user by id
	 * @param id
	 * @return
	 */


	@GetMapping("/{id}")
	public ResponseEntity<?> usersDetails(@PathVariable Long id) {
		return new ResponseEntity<>(pr.findById(id), HttpStatus.OK);
	}

	/**
	 * find owner by id
	 * @param id
	 * @return
	 */
	
	@GetMapping("/propietario/{id}")
	public ResponseEntity<?> propietarioDetails(@PathVariable Long id) {
		return new ResponseEntity<>(pr.findById(id), HttpStatus.OK);
	}
	
	/**
	 * find all
	 * @param propietario
	 * @return
	 */
	@GetMapping("/getall")
	public ResponseEntity<?> ListPropietarios(Propietario propietario) {
		return new ResponseEntity<>(pr.findAll(), HttpStatus.OK);

	}

	// get all

	@GetMapping("/todo")
	public List<Propietario> getPropietarios() {
		return pr.findAll();
	}

	// get all except lo que pasemos por parametro

	/**
	 * update status, 
	 * if status is disabled put enabled and vice versa
	 * @param id
	 * @param users
	 * @return
	 */
	
	@PutMapping("/modificarEstado/{id}")
	public String putMethod1(@PathVariable Long id, @RequestBody Users users) {
		Users s = us.findById(id).get();
		if (users.getStatus().equals("disabled")) {

			s.setStatus("enabled");
		} else {
			s.setStatus("disabled");
		}

		us.save(s);

		return "estado actualizado";
	}

	/**
	 * update users
	 * set admin false
	 * @param id
	 * @param users
	 * @return
	 */
	
	@PutMapping("/modificar/{id}")
	public String putMethod(@PathVariable Long id, @RequestBody Users users) {
		Users s = us.findById(id).get();
		s.setEmail(users.getEmail());
		s.setAdmin(false);
		s.setLogin(users.getLogin());
		s.setPassword(users.getPassword());
		s.setStatus(users.getStatus());

		us.save(s);

		return "usuario actualizado";
	}
	
	/**
	 * check if users exists in system
	 * @param id
	 * @return
	 */

	@GetMapping("existe/{id}")
	public ResponseEntity<?> usersDetails2(@PathVariable Long id) {
		return new ResponseEntity<>(pr.findById(id).isPresent(), HttpStatus.OK);
	}

	/**
	 * get password from a user
	 * @param id
	 * @return
	 */
	
	@GetMapping("/password/{id}")
	public ResponseEntity<?> usersDetailsUser(@PathVariable Long id) {
		return new ResponseEntity<>(us.findById(id).get().getPassword(), HttpStatus.OK);
	}

	/**
	 * get Login from a user
	 * @param id
	 * @return
	 */
	
	@GetMapping("/login/{id}")
	public ResponseEntity<?> userDetailsLogin(@PathVariable Long id) {
		return new ResponseEntity<>(us.findById(id).get().getLogin(), HttpStatus.OK);
	}

	// devolver el id a partir del login del usuario, getsession

	
	/**
	 * insert users , only users not groups
	 * @param users
	 */
	
	@PostMapping("/saveUser")
	public void guardar(@RequestBody Users users) {
		pr.save(users);
	}

	// pruebas
	// eliminar propietario por id, inlcuye usuario y grupo
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		pr.deleteById(id);
	}


}

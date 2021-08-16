package com.capgemini.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.Propietario;
import com.capgemini.model.Users;
import com.capgemini.model.DTO.PropietarioDTO;
import com.capgemini.model.DTO.PropietarioMapper;
import com.capgemini.repositories.PropietarioRepository;
import com.capgemini.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserRepository ur;
	
	@Autowired
	PropietarioRepository pr;
	
	@PostMapping("/add")
	public Propietario addPropietario(@RequestBody PropietarioDTO  propietario) {
	
//		if(propietario.getType().equals("usuario")) {
//			
//			Users user = (Users)propietario;
//			return pr.save(user);
//		}else if(propietario.getType().equals("grupo")){
//			
//			return null;
//		}
		return pr.save(PropietarioMapper.executed(propietario));
	
		

	}
}

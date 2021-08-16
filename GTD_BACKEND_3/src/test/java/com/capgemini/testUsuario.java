package com.capgemini;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.model.GroupUsers;
import com.capgemini.model.Groups;
import com.capgemini.model.Users;
import com.capgemini.service.GroupService;
import com.capgemini.service.GroupUserService;
import com.capgemini.service.PropietarioService;
import com.capgemini.service.UserService;



public class testUsuario {

//	@Autowired
//	GroupService gs;
//	
//	@Autowired
//	UserService us;
//	
//	@Autowired
//	PropietarioService ps;
//	
//	@Autowired
//	GroupUserService gus;
//	
//	@Test
//	@Order(1)
//	public void inicializar() {
//		us.save(new Users((long) 0,"Cristina"));
//		us.save(new Users((long) 0,"Rita"));
//		gs.save(new Groups((long) 0,"DAW"));
//		gs.save(new Groups((long) 0,"DAM"));
//		
//	}
//	@Test
//	@Order(2)
//	public void eliminarEnCascadaUsuario() {
//		us.deleteById((long) 1);
//		assertFalse(us.findById((long)1).isPresent());
//	}
//	@Test
//	@Order(3)
//	public void usuario() {
//		assertEquals(1,us.findByLoginIgnoreCaseContaining("cris")).get().size();
//	}
}

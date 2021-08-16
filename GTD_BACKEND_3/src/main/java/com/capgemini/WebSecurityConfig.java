package com.capgemini;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.capgemini.model.GroupUsers;
import com.capgemini.model.Groups;
import com.capgemini.model.Propietario;
import com.capgemini.model.Users;
import com.capgemini.repositories.GroupUsersRepository;
import com.capgemini.repositories.PropietarioRepository;

@Controller
public class WebSecurityConfig {
	
	@Autowired
	PropietarioRepository propietarioRepository;
	
	@Autowired
	GroupUsersRepository groupUsersRepository;
	
	public boolean authRouter(HttpSession httpSession) {
		Long id = (Long) httpSession.getAttribute("usuario");
		if(id == null)
			return false;
		else {
			 Optional<Propietario> propietario = propietarioRepository.findById(id);
			if(!propietario.isPresent())
				return false;
			else {
				if(propietario.get().getType().equals("usuario")) {
					return true;
				}
				else
					return false;
					
			}
		}
	}
	
	public boolean adminRouter(HttpSession httpSession) {
		Long id = (Long) httpSession.getAttribute("usuario");
		if(id == null)
			return false;
		else {
			 Optional<Propietario> propietario = propietarioRepository.findById(id);
			if(!propietario.isPresent())
				return false;
			else {
				if(propietario.get().getType().equals("usuario")) {
					Users usuario = (Users) propietario.get();
					return usuario.isAdmin();
				}
				else
					return false;
					
			}
		}
	}
	
	public boolean groupRouter(HttpSession httpSession, Long idGroup) {
		Long id = (Long) httpSession.getAttribute("usuario");
		if(id == null)
			return false;
		else {
			 Optional<Propietario> propietario = propietarioRepository.findById(id);
			if(!propietario.isPresent())
				return false;
			else {
				if(propietario.get().getType().equals("usuario")) {
					Users usuario = (Users) propietario.get();
					Groups groups = new Groups();
					groups.setId(idGroup);
					Optional<GroupUsers> groupU = groupUsersRepository.findByUsersAndGroups(usuario, groups);
					if(!groupU.isPresent())
						return false;
					else {
						return groupU.get().isAdmin();
					}
				}
				else
					return false;
					
			}
		}
	}
}
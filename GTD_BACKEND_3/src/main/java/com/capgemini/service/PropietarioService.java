package com.capgemini.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.capgemini.model.GroupUsers;
import com.capgemini.model.Propietario;
import com.capgemini.model.Users;


public interface PropietarioService {

	Propietario  save(Propietario propietario);
	
	void delete(Propietario propietario);
	
	void deleteById(Long id);
	
	GroupUsers saveGroup(GroupUsers groupUsers);

	Optional<Propietario> findByIdNot(Long id);
	
	List <Propietario> findAll();

	Propietario findById(Long id);
	
}

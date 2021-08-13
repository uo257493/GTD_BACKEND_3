package com.capgemini.service;

import com.capgemini.model.GroupUsers;
import com.capgemini.model.Propietario;

public interface PropietarioService {

	Propietario  save(Propietario propietario);
	
	void delete(Propietario propietario);
	
	void deleteById(Long id);
	
	GroupUsers saveGroup(GroupUsers groupUsers);
}

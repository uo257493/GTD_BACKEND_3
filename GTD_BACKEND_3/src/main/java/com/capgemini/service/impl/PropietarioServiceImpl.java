package com.capgemini.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.model.GroupUsers;
import com.capgemini.model.Propietario;
import com.capgemini.repositories.GroupUserRepository;
import com.capgemini.repositories.PropietarioRepository;
import com.capgemini.service.PropietarioService;

public class PropietarioServiceImpl implements PropietarioService {

	@Autowired
	private PropietarioRepository propietarioRepository;
	
	@Autowired
	private GroupUserRepository groupUserRepository;

	@Override
	public Propietario save(Propietario propietario) {
		// TODO Auto-generated method stub
		return propietarioRepository.save(propietario);
	}

	@Override
	public void delete(Propietario propietario) {
		// TODO Auto-generated method stub
		propietarioRepository.delete(propietario);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		propietarioRepository.deleteById(id);
	}

	@Override
	public GroupUsers saveGroup(GroupUsers groupUsers) {
		// TODO Auto-generated method stub
		return groupUserRepository.save(groupUsers);
	}

}

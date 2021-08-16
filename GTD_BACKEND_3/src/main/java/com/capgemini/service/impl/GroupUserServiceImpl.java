package com.capgemini.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.GroupUsers;
import com.capgemini.model.Propietario;
import com.capgemini.repositories.GroupUserRepository;
import com.capgemini.repositories.PropietarioRepository;
import com.capgemini.service.GroupUserService;

@Service
public class GroupUserServiceImpl implements GroupUserService {

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
	public List<GroupUsers> findAll() {
		// TODO Auto-generated method stub
		return groupUserRepository.findAll();
	}


	@Override
	public void delete(GroupUsers entity) {
		// TODO Auto-generated method stub
		groupUserRepository.delete(entity);
	}

}

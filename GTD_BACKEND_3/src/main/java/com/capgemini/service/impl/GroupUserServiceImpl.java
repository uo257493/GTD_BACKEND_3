package com.capgemini.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.Propietario;
import com.capgemini.repositories.PropietarioRepository;
import com.capgemini.service.GroupUserService;

@Service
public class GroupUserServiceImpl implements GroupUserService {

	@Autowired
	private PropietarioRepository propietarioRepository;
	
	
	@Override
	public Propietario save(Propietario propietario) {
		// TODO Auto-generated method stub
		return propietarioRepository.save(propietario);
	}

	
	
}

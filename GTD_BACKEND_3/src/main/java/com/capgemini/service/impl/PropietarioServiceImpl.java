package com.capgemini.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.GroupUsers;
import com.capgemini.model.Propietario;
import com.capgemini.repositories.GroupUserRepository;
import com.capgemini.repositories.PropietarioRepository;
import com.capgemini.service.PropietarioService;

@Service
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

	@Override
	public Optional<Propietario> findByIdNot(Long id) {
		// TODO Auto-generated method stub
		return propietarioRepository.findByIdNot(id);
	}

	

	@Override
	public Propietario findById(Long id) {
		Optional<Propietario> propietario = propietarioRepository.findById(id);
		if(propietario.isPresent()== false) {
			return null;
		}
		return propietario.get();
	}

	@Override
	public List<Propietario> findAll() {
		// TODO Auto-generated method stub
		return propietarioRepository.findAll();
	}

	


	
	




}

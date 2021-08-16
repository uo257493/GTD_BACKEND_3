package com.capgemini.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.Groups;
import com.capgemini.model.Propietario;
import com.capgemini.repositories.GroupRepository;
import com.capgemini.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService{

	@Autowired
	private GroupRepository groupRepository;

	@Override
	public Optional<Groups> findById(Long id) {
		// TODO Auto-generated method stub
		return groupRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		groupRepository.deleteById(id);
	}

	@Override
	public void save(Groups groups) {
		// TODO Auto-generated method stub
		groupRepository.save(groups);
		
	}

	@Override
	public List<Groups> findByDescripcionIgnoreCaseContaining(String descripcion) {
		// TODO Auto-generated method stub
		return groupRepository.findByDescripcionIgnoreCaseContaining(descripcion);
	}

	@Override
	public List<Groups> findByNombreIgnoreCaseContaining(String nombre) {
		// TODO Auto-generated method stub
		return groupRepository.findByNombreIgnoreCaseContaining(nombre);
	}

	@Override
	public List<Groups> findByFechaCreacion(Date fechaCreacion) {
		// TODO Auto-generated method stub
		return groupRepository.findByFechaCreacion(fechaCreacion);
	}


	public List<Groups> findAll() {
		return groupRepository.findAll();
	}

	public long count() {
		return groupRepository.count();
	}

	public void deleteById(Integer id) {
		groupRepository.deleteById(id);
	}

	public void delete(Groups entity) {
		groupRepository.delete(entity);
	}

	public void deleteAll() {
		groupRepository.deleteAll();
	}


	
	
}

package com.capgemini.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.capgemini.model.Groups;
import com.capgemini.model.Propietario;
import com.capgemini.service.impl.GroupServiceImpl;

public interface GroupService {

	Optional<Groups> findById(Long id);

	void deleteById(Long id);

	void save(Groups groups);

	List <Groups> findByDescripcionIgnoreCaseContaining(String descripcion);
	
	List<Groups> findByNombreIgnoreCaseContaining(String nombre);
	
	public List<Groups> findByFechaCreacion(Date fechaCreacion);
	
	long count();
	
	void deleteById(Integer id);
	
	void delete(Groups entity);
	
	void deleteAll();
}

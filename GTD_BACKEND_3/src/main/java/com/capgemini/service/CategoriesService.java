package com.capgemini.service;

import java.util.List;

import com.capgemini.model.Categories;
import com.capgemini.model.Propietario;
import com.capgemini.model.Tasks;

public interface CategoriesService {

	public Categories findById(Long id);
	
	public List<Categories> findByPropietario(Long Propietario);
	
	public List<Categories> findByName(String name);
	
	public <S extends Categories> S save(S entity);
	
	public boolean isPresent(Long id);
}

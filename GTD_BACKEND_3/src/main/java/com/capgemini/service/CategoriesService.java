package com.capgemini.service;

import java.util.List;

import com.capgemini.model.Categories;
import com.capgemini.model.Propietario;

public interface CategoriesService {

	public Categories findById(Long id);
	
	public List<Categories> findByPropietario(Long Propietario);
	
	public List<Categories> findByName(String name);
}

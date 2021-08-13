package com.capgemini.service;

import com.capgemini.model.Categories;
import com.capgemini.model.Propietario;

public interface CategoriesService {

	public Categories findById(Long id);
	
	public Categories findByPropietario(Propietario propietario);
}

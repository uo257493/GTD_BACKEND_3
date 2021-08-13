package com.capgemini.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.Categories;
import com.capgemini.repositories.CategoriesRepository;
import com.capgemini.repositories.UserRepository;
import com.capgemini.service.CategoriesService;

@Service
public class CategoriesServiceImpl implements CategoriesService{
	
	@Autowired
	private CategoriesRepository categoriesRepository;
	
	//buscar categoria por usuario.
	@Override
	public Categories findById(Long id) {
		Optional<Categories> cateOptional = categoriesRepository.findById(id);
		if(cateOptional.isPresent()) {
			return cateOptional.get();
		}
		throw new IllegalArgumentException("No existe la categoría");
	}
	
	
}
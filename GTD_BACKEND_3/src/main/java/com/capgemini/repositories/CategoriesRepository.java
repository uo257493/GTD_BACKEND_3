package com.capgemini.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

import com.capgemini.model.Categories;
import com.capgemini.model.Propietario;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long>{

	/*
	 * obtiene categorias por ID propietario
	 */
	public List<Categories> findByPropietario(Propietario propiedario);
	
	public List<Categories> findByName(String name);
	
	
}

package com.capgemini.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.config.Task;

import com.capgemini.model.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Long>{

	/**
	 * Obtiene categoria por ID de la misma.
	 */
	//	@Query("SELECT c FROM Categories c WHERE c.id=?")
	//	public Categories findCategoryPorId(Long id); 
	
}

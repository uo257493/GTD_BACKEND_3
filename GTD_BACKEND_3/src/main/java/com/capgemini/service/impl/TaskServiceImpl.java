package com.capgemini.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import com.capgemini.model.Categories;
import com.capgemini.model.Tasks;
import com.capgemini.repositories.TaskRepository;
import com.capgemini.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;

	
	/**
	 * Añade la tarea
	 * @param entity, dada
	 * @return la tarea añadida
	 * @throws Exception
	 */
	@Override
	public Tasks save(Tasks entity) throws Exception {
		Tasks t =  taskRepository.save(entity);
		if(t == null)
			throw new Exception("La tarea no es valida");
		return t;
	}

	
	/**
	 * Busca la tarea con un
	 * @param id
	 * @return devolviendo el objeto tarea
	 */
	@Override
	public Tasks findById(Long id) {
		return taskRepository.findById(id).get();
	}
	
//	@Autowired
//	CategoryRepository categoryRepository;
	/**
	 * Lista las tareas en funcion a su categorias
	 */
	@Override 
	public List<Tasks> listTasks(Long id, boolean passedDate){
		String name = "";
		if(id==-1)
			name="inbox";
		else if(id==-2)
			name="hoy";
		
		if(!passedDate) {
			if(name.equals("inbox")) {
				Categories categories = new Categories();
				categories.setId(null);
				return taskRepository.findByCategoryAndPlannedGreaterThanEqualOrderByPlannedAsc(categories, new java.sql.Date(System.currentTimeMillis()));}
			else if (name.equals("hoy")) {
				return taskRepository.findByPlannedEqualsOrderByPlannedAsc(new java.sql.Date(System.currentTimeMillis()));
			}
			else {
			
				Categories categories = null; //categoryRepository.getById(id)
				return taskRepository.findByCategoryAndPlannedGreaterThanEqualOrderByPlannedAsc(categories, new java.sql.Date(System.currentTimeMillis()));
				
			}
		}
		else {
			if(name.equals("inbox")) {
				Categories categories = new Categories();
				categories.setId(null);
				return taskRepository.findByCategoryOrderByPlannedAsc(categories);}
			else if (name.equals("hoy")) {
				return taskRepository.findByPlannedGreaterThanEqualOrderByPlannedAsc(null);
			}
			else {
			
				Categories categories = null; //categoryRepository.getById(id)
				return taskRepository.findByCategoryOrderByPlannedAsc(categories);
			}
				
		}
		
	}
	
	
	
	
}

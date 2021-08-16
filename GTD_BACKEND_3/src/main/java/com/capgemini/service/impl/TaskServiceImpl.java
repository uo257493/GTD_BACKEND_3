package com.capgemini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.Categories;
import com.capgemini.model.Propietario;
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
	public List<Tasks> listTasks(Long id, Long idUsuario, boolean passedDate){
//		if(1==1)
//			return taskRepository.findByPropietarioAndCategoryOrderByPlannedAsc(new Propietario(1L, null), null);
		String name = "";
		if(id==0)
			name="inbox";
		else if(id==1)
			name="hoy";
		
		if(!passedDate) {
			if(name.equals("inbox")) {
				Propietario p = new Propietario();
				p.setId(idUsuario);
				Categories categories = new Categories();
				categories.setId(null);
				return taskRepository.findByPropietarioAndCategoryAndPlannedGreaterThanEqualOrPlannedEqualsAndPropietarioOrderByPlannedAsc(p, null, new java.sql.Date(System.currentTimeMillis()), null, p);}
			else if (name.equals("hoy")) {
				Propietario p = new Propietario();
				p.setId(idUsuario);
				return taskRepository.findByPropietarioAndPlannedGreaterThanEqualOrPlannedEqualsAndPropietarioOrderByPlannedAsc(p, new java.sql.Date(System.currentTimeMillis()), null, p);
			}
			else {
			
				Categories categories = new Categories(); //categoryRepository.getById(id)
				categories.setId(id);
				return taskRepository.findByCategoryAndPlannedGreaterThanEqualOrPlannedEqualsOrderByPlannedAsc(categories, new java.sql.Date(System.currentTimeMillis()), null);
				
			}
		}
		else {
			if(name.equals("inbox")) {
				Propietario p = new Propietario();
				p.setId(idUsuario);
				Categories categories = new Categories();
				categories.setId(null);
				return taskRepository.findByPropietarioAndCategoryOrderByPlannedAsc(p, null);}
			else if (name.equals("hoy")) {
				Propietario p = new Propietario();
				p.setId(idUsuario);
				return taskRepository.findByPropietarioAndPlannedEqualsOrderByPlannedAsc(p, new java.sql.Date(System.currentTimeMillis()));
			}
			else {
			
				Categories categories = new Categories(); //categoryRepository.getById(id)
				categories.setId(id);
				return taskRepository.findByCategoryOrderByPlannedAsc(categories);
			}
				
		}
		
	}
	
	
	
	
}

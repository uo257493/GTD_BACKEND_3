package com.capgemini.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import com.capgemini.model.Categories;
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
	public Task save(Task entity) throws Exception {
		Task t =  taskRepository.save(entity);
		if(t == null)
			throw new Exception("La tarea no es valida");
		return t;
	}

	/**Lista las tareas de una
	 * @param category
	 * a partir de una fecha
	 * @param date, sin incluir las pasadas
	 * @return
	 */
	@Override
	public List<Task> findByCategoryAndPlannedGreaterThanEqualOrderByPlannedAsc(Categories category, Date date) {
		return taskRepository.findByCategoryAndPlannedGreaterThanEqualOrderByPlannedAsc(category, date);
	}

	/**Lista las tareas de una
	 * @param category
	 * @return
	 */
	@Override
	public List<Task> findByCategoryAndPlannedOrderByPlannedAsc(Categories category) {
		return taskRepository.findByCategoryAndPlannedOrderByPlannedAsc(category);
	}

	/**Lista las tareas de una
	 * a partir de una fecha
	 * @param date, sin incluir las pasadas
	 * @return
	 */
	@Override
	public List<Task> findPlannedGreaterThanEqualOrderByPlannedAsc(Date date) {
		return taskRepository.findPlannedGreaterThanEqualOrderByPlannedAsc(date);
	}

	/**Lista las tareas de una
	 * a partir de una fecha
	 * @param date, sin incluir las pasadas
	 * @return
	 */
	@Override
	public List<Task> findPlannedEqualsOrderByPlannedAsc(Date date) {
		return taskRepository.findPlannedEqualsOrderByPlannedAsc(date);
	}

	/**
	 * Busca la tarea con un
	 * @param id
	 * @return devolviendo el objeto tarea
	 */
	@Override
	public Optional<Task> findById(Long id) {
		return taskRepository.findById(id);
	}
	
	
	
	
	
}

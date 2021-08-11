package com.capgemini.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.scheduling.config.Task;

import com.capgemini.model.Categories;

public interface TaskService {

	/**
	 * Añade la tarea
	 * @param entity, dada
	 * @return la tarea añadida
	 * @throws Exception
	 */
	Task save(Task entity) throws Exception;

	/**Lista las tareas de una
	 * @param category
	 * a partir de una fecha
	 * @param date, sin incluir las pasadas
	 * @return
	 */
	List<Task> findByCategoryAndPlannedGreaterThanEqualOrderByPlannedAsc(Categories category, Date date);

	/**Lista las tareas de una
	 * @param category
	 * @return
	 */
	List<Task> findByCategoryAndPlannedOrderByPlannedAsc(Categories category);

	/**Lista las tareas de una
	 * a partir de una fecha
	 * @param date, sin incluir las pasadas
	 * @return
	 */
	List<Task> findPlannedGreaterThanEqualOrderByPlannedAsc(Date date);

	/**Lista las tareas de una
	 * a partir de una fecha
	 * @param date, sin incluir las pasadas
	 * @return
	 */
	List<Task> findPlannedEqualsOrderByPlannedAsc(Date date);

	/**
	 * Busca la tarea con un
	 * @param id
	 * @return devolviendo el objeto tarea
	 */
	Optional<Task> findById(Long id);

}
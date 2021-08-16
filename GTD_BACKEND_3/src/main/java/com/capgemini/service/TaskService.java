package com.capgemini.service;

import java.util.List;

import com.capgemini.model.Tasks;

public interface TaskService {

	/**
	 * Añade la tarea
	 * @param entity, dada
	 * @return la tarea añadida
	 * @throws Exception
	 */
	Tasks save(Tasks entity) throws Exception;

	/**
	 * Busca la tarea con un
	 * @param id
	 * @return devolviendo el objeto tarea
	 */
	Tasks findById(Long id);

	/**
	 * Lista las tareas de una
	 * @param id, categoria
	 * @param idUsuario, id del usuario
	 * @param passedDate, indicando si quiere añadir las de dias pasados
	 * @return lista de tareas
	 */
	List<Tasks> listTasks(Long id, Long idUsuario, boolean passedDate);

}
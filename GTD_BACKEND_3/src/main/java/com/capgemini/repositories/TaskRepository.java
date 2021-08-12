package com.capgemini.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;

import com.capgemini.model.Categories;

public interface TaskRepository extends JpaRepository<Task, Long> {
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
	

	
}

package com.capgemini.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.model.Categories;
import com.capgemini.model.Tasks;

public interface TaskRepository extends JpaRepository<Tasks, Long> {
	/**Lista las tareas de una
	 * @param category
	 * a partir de una fecha
	 * @param date, sin incluir las pasadas
	 * @return
	 */
	List<Tasks> findByCategoryAndPlannedGreaterThanEqualOrderByPlannedAsc(Categories category, Date date);
	
	/**Lista las tareas de una
	 * @param category
	 * @return
	 */
	List<Tasks> findByCategoryOrderByPlannedAsc(Categories category);

	
	/**Lista las tareas de una
	 * a partir de una fecha
	 * @param date, sin incluir las pasadas
	 * @return
	 */
	List<Tasks> findByPlannedGreaterThanEqualOrderByPlannedAsc(Date date);
	
	
	/**Lista las tareas de una
	 * a partir de una fecha
	 * @param date, sin incluir las pasadas
	 * @return
	 */
	List<Tasks> findByPlannedEqualsOrderByPlannedAsc(Date date);
	

	
}

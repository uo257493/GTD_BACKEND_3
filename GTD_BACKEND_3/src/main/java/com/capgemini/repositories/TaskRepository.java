package com.capgemini.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.model.Categories;
import com.capgemini.model.Propietario;
import com.capgemini.model.Tasks;

public interface TaskRepository extends JpaRepository<Tasks, Long> {
	/**Lista las tareas de una
	 * @param category
	 * a partir de una fecha
	 * @param date, sin incluir las pasadas
	 * @return
	 */
	List<Tasks> findByCategoryAndPlannedGreaterThanEqualOrPlannedEqualsOrderByPlannedAsc(Categories category, Date date, Date date2);
	
	/**Lista las tareas de una
	 * @param category (inbox)
	 * a partir de una fecha
	 * @param date, sin incluir las pasadas
	 * @return
	 */
	List<Tasks> findByPropietarioAndCategoryAndPlannedGreaterThanEqualOrPlannedEqualsAndPropietarioOrderByPlannedAsc(Propietario propietario,Categories category, Date date, Date date2, Propietario p);
	
	/**Lista las tareas de una
	 * @param category
	 * @return
	 */
	List<Tasks> findByCategoryOrderByPlannedAsc(Categories category);

	/**Lista las tareas de una
	 * @param category (inbox)
	 * @return
	 */
	List<Tasks> findByPropietarioAndCategoryOrderByPlannedAsc(Propietario propietario, Categories category);
	
	/**Lista las tareas de una
	 * a partir de una fecha
	 * @param date, sin incluir las pasadas
	 * @return
	 */
	List<Tasks> findByPropietarioAndPlannedGreaterThanEqualOrPlannedEqualsAndPropietarioOrderByPlannedAsc(Propietario propietario, Date date, Date date2, Propietario p2);
	
	
	/**Lista las tareas de una
	 * a partir de una fecha
	 * @param date, sin incluir las pasadas
	 * @return
	 */
	List<Tasks> findByPropietarioAndPlannedEqualsOrderByPlannedAsc(Propietario propietario, Date date);
	
	

	
}

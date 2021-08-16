package com.capgemini.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.model.Groups;

public interface GroupRepository extends JpaRepository<Groups, Integer> {

	Optional<Groups> findById(Long id);

	void deleteById(Long id);
	
	/**
	 * find group by description
	 * @param descripcion
	 * @return
	 */
	public List <Groups> findByDescripcionIgnoreCaseContaining(String descripcion);
	

	/**
	 * find group by nombre
	 * @param nombre
	 * @return
	 */
	public List<Groups> findByNombreIgnoreCaseContaining(String nombre);
	
	/**
	 * find group by date
	 * @param fechaCreacion
	 * @return
	 */
	
	public List<Groups> findByFechaCreacion(Date fechaCreacion);
}

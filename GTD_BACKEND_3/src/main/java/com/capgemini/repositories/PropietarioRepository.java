package com.capgemini.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.capgemini.model.GroupUsers;
import com.capgemini.model.Groups;
import com.capgemini.model.Propietario;
import com.capgemini.model.Users;
import com.capgemini.model.DTO.PropietarioDTO;


public interface PropietarioRepository extends JpaRepository<Propietario, Long> {



	Users getByPassword(String password);

	
	//public List<Propietario> findByTypeIgnoreCaseContaining(String type);
	/**
	 * find propietario/user by login
	 * @param login
	 * @return
	 */
	
	public List <Users> findByLoginIgnoreCaseContaining(String login);

	/**
	 * find propietario/user by email
	 * @param email
	 * @return
	 */
	public List <Users> findByEmailIgnoreCaseContaining(String email);
	
	/**
	 * find propietario by type
	 * @param type
	 * @return
	 */
	public List <Propietario> findByTypeIgnoreCaseContaining(String type);
	
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
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Optional<Propietario> findByIdNot(Long id);

	
}

package com.capgemini.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.capgemini.model.GroupUsers;
import com.capgemini.model.Propietario;
import com.capgemini.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	Propietario save(Propietario propietario);
	
	Propietario delete(Propietario propietario);

	Optional<Users> findById(Long id);
	
	/**
	 * find user by login
	 * @param login
	 * @return
	 */

	public List <Users> findByLoginIgnoreCaseContaining(String login);
	
	/**
	 * find user by email
	 * @param email
	 * @return
	 */
	public List<Users> findByEmailIgnoreCaseContaining(String email);
	
	/**
	 * find useer by status
	 * @param status
	 * @return
	 */
	public List<Users> findByStatusIgnoreCaseContaining(String status);
	

	/**
	 * get all except  x param
	 * @param id
	 * @return
	 */
	Optional<Users> findByIdNot(Long id);

}

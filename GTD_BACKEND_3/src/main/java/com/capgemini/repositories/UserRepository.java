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

	public List <Users> findByLoginIgnoreCaseContaining(@Param("login") String login);
	

	
//	List<Users> ListUsuarios(Long id);

}

package com.capgemini.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.capgemini.model.Propietario;
import com.capgemini.model.Users;

public interface PropietarioRepository extends JpaRepository<Propietario, Long> {



	Users getByPassword(String password);

	
	public List <Users> findByLoginIgnoreCaseContaining(@Param("login") String login);


	Optional<Propietario> findByIdNot(Long id);
	

}

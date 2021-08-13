package com.capgemini.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.model.GroupUsers;
import com.capgemini.model.Propietario;
import com.capgemini.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	Propietario save(Propietario propietario);
	
	Propietario delete(Propietario propietario);

	Optional<Users> findById(Long id);


//	List<Users> ListUsuarios(Long id);

}

package com.capgemini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.model.GroupUsers;
import com.capgemini.model.Propietario;
import com.capgemini.model.Users;

public interface PropietarioRepository extends JpaRepository<Propietario, Long> {



	Users getByPassword(String password);
	
	



}

package com.capgemini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.model.Propietario;
import com.capgemini.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	Propietario save(Propietario propietario);

}
package com.capgemini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.model.Propietario;
import com.capgemini.model.Users;

public interface PropietarioRepository extends JpaRepository<Propietario, Long> {

//	List<Users> findAllExcept();

	Users getByPassword(String password);

//	Users getAllExcept(String login);

//	Users getBySession(String login);

	//boolean existsUser(Users users);


}

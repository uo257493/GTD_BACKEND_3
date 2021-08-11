package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;

import com.capgemini.model.Users;

public interface UserService {

	Users getByPassword(String password);

	<S extends Users> S save(S entity);

	List<Users> findAll();

	Optional<Users> findById(Long id);

	boolean existsById(Long id);

	long count();

	void deleteById(Long id);

	void delete(Users users);

	void deleteAll();

	Users getById(Long id);

	Users getAllExcept(String login);

	Users getBySession(String login);

	Users update(Long id, Users users);

	List<Users> findAllExcept();

	boolean existsUser(Users users);
	
	void updateStatus(String status);

}
package com.capgemini.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.model.Propietario;
import com.capgemini.model.Users;
import com.capgemini.repositories.UserRepository;
import com.capgemini.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository; 
//	Users getByPassword(String password);
//
	//Propietario  save(Propietario propietario);
//
//	List<Users> findAll();
//
//	Optional<Users> findById(Long id);
//
//	boolean existsById(Long id);
//
//	long count();
//
//	void deleteById(Long id);
//
//	void delete(Users users);
//
//	void deleteAll();
//
//	Users getById(Long id);
//
////	Users getAllExcept(String login);
//
////	Users getBySession(String login);
//
//	Users update(Long id, Users users);
//
////	List<Users> findAllExcept();
//
//@Override
//boolean existsUser(Users users);
	


	@Override
	public Users save(Users users) {
		// TODO Auto-generated method stub
		return userRepository.save(users);
	}

}
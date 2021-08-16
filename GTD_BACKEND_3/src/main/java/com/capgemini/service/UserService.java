package com.capgemini.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.model.GroupUsers;
import com.capgemini.model.Users;
import com.capgemini.repositories.GroupUserRepository;

public interface UserService {

	Users  save(Users users);	

	GroupUsers save(GroupUsers groupUsers);
	
	void deleteById(int id);
	
	Optional<Users> findById(Long id);

	void deleteById(Long id);
	

	List <Users> findByLoginIgnoreCaseContaining(String login);
	
	
	List<Users> findByEmailIgnoreCaseContaining(String email);
	
	List<Users> findByStatusIgnoreCaseContaining(String status);
	//List<Users> findById(Long id);
}

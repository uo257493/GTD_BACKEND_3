package com.capgemini.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.GroupUsers;
import com.capgemini.model.Users;
import com.capgemini.repositories.GroupUserRepository;
import com.capgemini.repositories.UserRepository;
import com.capgemini.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private GroupUserRepository groupUserRepository;
	



	@Override
	public Users save(Users users) {
		// TODO Auto-generated method stub
		return userRepository.save(users);
	}
	
	@Override 
	public GroupUsers save(GroupUsers groupUsers) {
		return groupUserRepository.save(groupUsers);
	}
//
//	@Override
//	public List<Users> ListUsusarios(Long id) {
//		// TODO Auto-generated method stub
//		return userRepository.ListUsuarios(id);
//	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	@Override
	public Optional<Users> findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		userRepository.findById(id);
	}

//	@Override
//	public void deleteById(Long id) {
//		// TODO Auto-generated method stub
//		return userRepository.findById(id);
//	}


	

}
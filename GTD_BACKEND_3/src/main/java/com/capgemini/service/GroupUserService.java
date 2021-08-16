package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.model.GroupUsers;
import com.capgemini.model.Groups;
import com.capgemini.model.Propietario;
import com.capgemini.model.Users;

public interface GroupUserService {

	Propietario save(Propietario propietario);

//	List<GroupUsers> findByGroups(Groups groups);
//
//	List<GroupUsers> findByUsers(Users users);
//	

	List<GroupUsers> findAll();

	void delete(GroupUsers entity);

}

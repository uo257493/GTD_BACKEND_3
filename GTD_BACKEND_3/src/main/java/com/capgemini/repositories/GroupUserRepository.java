package com.capgemini.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.model.GroupUsers;
import com.capgemini.model.Groups;
import com.capgemini.model.Users;


public interface GroupUserRepository extends JpaRepository<GroupUsers, Integer>{



	
//	//usuarios de 1 grupo
	//List<GroupUsers> findByGroups(Groups groups);
////	// cursos de un alumno
//	List<GroupUsers> findByUsers(Users users);
//	
}

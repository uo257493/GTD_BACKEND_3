package com.capgemini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.model.GroupUsers;
import com.capgemini.model.Propietario;

public interface GroupUserRepository extends JpaRepository<GroupUsers, Integer>{

	//GroupUsers saveGroup(GroupUsers groupUsers);

//	Propietario save(Propietario propietario);
}

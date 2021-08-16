package com.capgemini.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.model.GroupUsers;
import com.capgemini.model.Groups;
import com.capgemini.model.Users;

public interface GroupUsersRepository extends JpaRepository<GroupUsers, Long> {

	public Optional<GroupUsers> findByUsersAndGroups(Users users, Groups groups);
}

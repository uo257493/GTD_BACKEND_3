package com.capgemini.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	List<Users> findAllExcept();

	Users getByPassword(String password);

	Users getAllExcept(String login);

	Users getBySession(String login);

	boolean existsUser(Users users);

	void updateStatus(String status);

}

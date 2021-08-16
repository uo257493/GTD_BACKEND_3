package com.capgemini.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.model.Groups;

public interface GroupRepository extends JpaRepository<Groups, Integer> {

	Optional<Groups> findById(Long id);

	void deleteById(Long id);

}

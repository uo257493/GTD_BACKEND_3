package com.capgemini.service;

import java.util.Optional;

import com.capgemini.model.Groups;
import com.capgemini.service.impl.GroupServiceImpl;

public interface GroupService {

	Optional<Groups> findById(Long id);

	void deleteById(Long id);

}

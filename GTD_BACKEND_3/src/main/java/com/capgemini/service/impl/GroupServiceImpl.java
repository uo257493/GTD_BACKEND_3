package com.capgemini.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.Groups;
import com.capgemini.repositories.GroupRepository;
import com.capgemini.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService{

	@Autowired
	private GroupRepository groupRepository;

	@Override
	public Optional<Groups> findById(Long id) {
		// TODO Auto-generated method stub
		return groupRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		groupRepository.deleteById(id);
	}
	
	
}

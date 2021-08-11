package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.Users;
import com.capgemini.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public <S extends Users> S save(S entity) {
		return userRepository.save(entity);
	}

	@Override
	public List<Users> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<Users> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return userRepository.existsById(id);
	}

	@Override
	public long count() {
		return userRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public void delete(Users entity) {
		userRepository.delete(entity);
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}

	@Override
	public Users getById(Long id) {
		return userRepository.getById(id);
	}

	@Override
	public Users getByPassword(String password) {
		return userRepository.getByPassword(password);
	}

	@Override
	public Users update(Long id, Users users) {
		Optional<Users> userOptional = userRepository.findById(id);
		if (userOptional.isEmpty()) {
			throw new IllegalArgumentException("No existe ningún usuario con id " + id);
		}
		return userRepository.save(users);
	}

	@Override
	public List<Users> findAllExcept() {
		return userRepository.findAllExcept();
	}

	@Override
	public Users getAllExcept(String login) {
		return userRepository.getAllExcept(login);
	}

	@Override
	public Users getBySession(String login) {

		return userRepository.getBySession(login);
	}

	@Override
	public boolean existsUser(Users users) {
		return userRepository.existsUser(users);
	}

	@Override
	public void updateStatus(String status) {
		userRepository.updateStatus(status);

	}

}

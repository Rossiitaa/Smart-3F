package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(long id,User user) {
		User u=userRepository.getReferenceById(id);
		u.setCognome(user.getCognome());
		u.setNome(user.getNome());
		u.setStates(user.getStates());
		return userRepository.save(u);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	
	
	
}

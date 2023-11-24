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
		u.setLastname(user.getLastname());
		u.setFirstname(user.getFirstname());
		u.setUser_states(user.getUser_states());
		return userRepository.save(u);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	
	
	
}

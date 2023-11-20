package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.PutExchange;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getUsers")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@PostMapping("/saveUser")
	public User saveUser(User user) {
		return userService.saveUser(user);
	}
	
	@PutMapping("/updateUser")
	public User updateUser(User user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	
	
	

}

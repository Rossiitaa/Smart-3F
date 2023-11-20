package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.PutExchange;

import com.example.demo.model.State;
import com.example.demo.model.User;
import com.example.demo.model.User_State;
import com.example.demo.service.StateService;
import com.example.demo.service.UserService;
import com.example.demo.service.UserStateService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserStateController {
	
	@Autowired
	private UserStateService userStateService;
	
	@GetMapping("/getUserStates")
	public List<User_State> getUserStates(){
		return userStateService.getUserStates();
	}
	
	@PostMapping("/saveUserState")
	public User_State saveUserState(@RequestBody User_State user_state) {
		return userStateService.saveUserState(user_state);
	}
	
	@PutMapping("/updateUserState/{user_id}/{state_id}")
	public User_State updateUserState(@RequestBody User_State user_state, @PathVariable Long user_id, @PathVariable Long state_id) {
		return userStateService.updateUserState(user_state, user_id, state_id);
	}
	
	@DeleteMapping("/deleteUserState/{user_id}/{state_id}")
	public void deleteUserState(@PathVariable Long user_id, @PathVariable Long state_id) {
		userStateService.deleteUserState(user_id, state_id);
	}
	
	
	

}
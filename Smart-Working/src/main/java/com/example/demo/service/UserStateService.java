package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User_State;
import com.example.demo.repository.UserStateRepository;

@Service
public class UserStateService {
	
	@Autowired
	private UserStateRepository userStateRepository;

	public List<User_State> getUserStates() {
		return userStateRepository.findAll();
	}

	public User_State saveUserState(User_State user_state) {
		return userStateRepository.save(user_state);
	}

	public User_State updateUserState(User_State user_state, Long user_id, Long state_id) {
		User_State us=userStateRepository.getReferenceById(state_id);
		us.setDate(user_state.getDate());
		us.setState(user_state.getState());
		us.setUser(user_state.getUser());
		return userStateRepository.save(us);
	}

	public void deleteUserState(Long user_id, Long state_id) {
		userStateRepository.deleteById(state_id);
	}
	
	

}

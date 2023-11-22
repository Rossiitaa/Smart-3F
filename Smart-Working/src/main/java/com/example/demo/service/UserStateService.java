package com.example.demo.service;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Request;
import com.example.demo.model.State;
import com.example.demo.model.User;
import com.example.demo.model.UserStateKey;
import com.example.demo.model.User_State;
import com.example.demo.repository.StateRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserStateRepository;

@Service
public class UserStateService {
	
	@Autowired
	private UserStateRepository userStateRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired 
	private UserRepository userRepository;
	
	public List<User_State> getUserStates() {
		return userStateRepository.findAll();
	}


	public User_State saveUserState(Request request, Long user_id, Long state_id) {
		// TODO Auto-generated method stub
		State s = stateRepository.getReferenceById(state_id);
		User u = userRepository.getReferenceById(user_id);
		UserStateKey usk = new UserStateKey(user_id, state_id, request.getData());
		User_State us = new User_State(usk,u,s);
			
		us.setOre(request.getOre());
		
		return userStateRepository.save(us);
	}
	
	


	public User_State updateUserState(Request request, Long user_id, Long state_id) {
		UserStateKey usk = new UserStateKey(user_id,state_id,request.getData());
		User u = userRepository.getReferenceById(user_id);
		State s = stateRepository.getReferenceById(state_id);
		User_State us=userStateRepository.getReferenceById(usk);
		us.setState(s);
		us.setUser(u);
		us.setOre(request.getOre());
		return userStateRepository.save(us);
	}

	public void deleteUserState(Request request, Long user_id, Long state_id) {
		UserStateKey usk = new UserStateKey(user_id,state_id,request.getData());
		userStateRepository.deleteById(usk);
	}


	public List<User> getAllAbsentByDate(Date date) {
		// TODO Auto-generated method stub
		State s = stateRepository.getReferenceById((long) 1);
		List<User_State> us = userStateRepository.findAllByState(s);
		
		System.out.println(us);
		List<User> usdate = new ArrayList<User>();
		
		for(User_State u : us) {
			if(u.getId().getDate().equals(date))
				usdate.add( userRepository.getReferenceById( u.getUser().getId()) );
		}
		
		return usdate;
	}
	


}

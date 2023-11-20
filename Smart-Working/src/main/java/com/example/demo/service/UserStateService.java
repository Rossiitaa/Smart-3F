package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User_State;
import com.example.demo.repository.UserStateRepository;

@Service
public class UserStateService {
	
	@Autowired
	private UserStateRepository userStateRepository;
	
	

}

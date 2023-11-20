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

import com.example.demo.model.State;
import com.example.demo.model.User;
import com.example.demo.service.StateService;
import com.example.demo.service.UserService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class StateController {
	
	@Autowired
	private StateService stateService;
	
	@GetMapping("/getStates")
	public List<State> getStates(){
		return stateService.getStates();
	}
	
	@PostMapping("/saveState")
	public State saveState(State state) {
		return stateService.saveState(state);
	}
	
	@PutMapping("/updateState")
	public State updateState(State state) {
		return stateService.updateState(state);
	}
	
	@DeleteMapping("/deleteState/{id}")
	public void deleteState(@PathVariable Long id) {
		stateService.deleteState(id);
	}
	
	
	

}
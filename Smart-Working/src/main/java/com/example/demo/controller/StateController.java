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

import com.example.demo.model.State;
import com.example.demo.service.StateService;

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
	public State saveState(@RequestBody State state) {
		return stateService.saveState(state);
	}
	
	@PutMapping("/updateState/{id}")
	public State updateState(@RequestBody State state,@PathVariable Long id) {
		return stateService.updateState(state,id);
	}
	
	@DeleteMapping("/deleteState/{id}")
	public void deleteState(@PathVariable Long id) {
		stateService.deleteState(id);
	}
	
	
	

}
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.State;
import com.example.demo.repository.StateRepository;

@Service
public class StateService {
	
	@Autowired
	private StateRepository stateRepository;

	public List<State> getStates() {
		return stateRepository.findAll() ;
	}

	public State saveState(State state) {
		return stateRepository.save(state);
	}

	public State updateState(State state,Long id) {
		State s= stateRepository.getReferenceById(id);
		s.setState(state.getState());
		s.setUsers(state.getUsers());
		return stateRepository.save(s);
	}

	public void deleteState(Long id) {
		stateRepository.deleteById(id);
	}
	

}

package com.example.demo.model;

import java.util.List;

import org.aspectj.lang.annotation.control.CodeGenerationHint;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class State {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long state_id;
	private States state;
	
	@OneToMany(mappedBy="state")
	private List<User_State> user_states;
	
	public State() {
		
	}

	public State(States state, List<User_State> user_states) {
		super();
		this.state = state;
		this.user_states = user_states;
	}

	public Long getState_id() {
		return state_id;
	}

	public void setState_id(Long state_id) {
		this.state_id = state_id;
	}

	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}

	public List<User_State> getUsers() {
		return user_states;
	}

	public void setUsers(List<User_State> user_states) {
		this.user_states = user_states;
	}
	
	
	
}

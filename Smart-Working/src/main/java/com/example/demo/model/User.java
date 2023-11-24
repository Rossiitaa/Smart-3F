package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long user_id;
	private String firstname;
	private String lastname;
	
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<User_State> user_states;
	
	
	public User() {
		
	}


	public User(String firstname, String lastname, List<User_State> user_states) {

		this.firstname = firstname;
		this.lastname = lastname;
		this.user_states = user_states;
	}


	public Long getUser_id() {
		return user_id;
	}


	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public List<User_State> getUser_states() {
		return user_states;
	}


	public void setUser_states(List<User_State> user_states) {
		this.user_states = user_states;
	}



	

}

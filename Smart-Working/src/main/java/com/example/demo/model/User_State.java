package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class User_State {
	
	@EmbeddedId
	UserStateKey id;
	
	@ManyToOne
	@MapsId("userid")
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@MapsId("stateid")
	@JoinColumn(name="state_id")
	
	private State state;
	
	Date date;
	int ore;
	
	public User_State() {
		
	}

	public User_State(User user, State state, Date date) {
		
		this.user = user;
		this.state = state;
		this.date = date;
	}

	public UserStateKey getId() {
		return id;
	}

	public void setId(UserStateKey id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	
	

}

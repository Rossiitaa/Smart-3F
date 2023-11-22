package com.example.demo.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class User_State {
	
	@EmbeddedId
	UserStateKey id;
	
	@ManyToOne
	@JsonIgnore
	@MapsId("userid")
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JsonIgnore
	@MapsId("stateid")
	@JoinColumn(name="state_id")
	
	private State state;
	
	
	int ore;
	
	public User_State() {
		
	}

	public User_State(UserStateKey usk, User user, State state) {
		
		this.id=usk;
		this.user = user;
		this.state = state;
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

	public int getOre() {
		return ore;
	}

	public void setOre(int ore) {
		this.ore = ore;
	}

	@Override
	public String toString() {
		return "User_State [id=" + id + ", user=" + user + ", state=" + state + ", ore=" + ore + "]";
	}
	
	
	
	
	
	
	

}

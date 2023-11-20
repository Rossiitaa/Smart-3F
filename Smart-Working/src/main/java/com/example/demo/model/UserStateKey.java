package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserStateKey implements Serializable{
	
	@Column (name="user_id")
	private Long userid;
	@Column (name="state_id")
	private Long stateid;
	
	public UserStateKey() {
		
	}

	public UserStateKey(Long userid, Long stateid) {
		super();
		this.userid = userid;
		this.stateid = stateid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getStateid() {
		return stateid;
	}

	public void setStateid(Long stateid) {
		this.stateid = stateid;
	}
	
	

}

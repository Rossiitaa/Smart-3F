package com.example.demo.model;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Embeddable
public class UserStateKey implements Serializable{
	
	@Column (name="user_id")
	private Long userid;
	@Column (name="state_id")
	private Long stateid;
	Date date;
	
	public UserStateKey() {
		
	}

	
	public UserStateKey(Long userid, Long stateid, Date date) {
		super();
		this.userid = userid;
		this.stateid = stateid;
		this.date = date;
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


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	

}

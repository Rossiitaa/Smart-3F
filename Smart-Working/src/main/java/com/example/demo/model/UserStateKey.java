package com.example.demo.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserStateKey implements Serializable{
	
	@Column (name="user_id")
	private Long userid;
	@Column (name="state_id")
	private Long stateid;
	@Column(name = "date")
	private LocalDate date;
	
	public UserStateKey() {
		
	}

	
	public UserStateKey(Long userid, Long stateid, LocalDate date) {
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


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}



	

}

package com.example.demo.model;

import java.sql.Date;

public class Request {
	
	private Date date;
	private Integer ore;
	
	public Request() {
		
	}

	public Request(Date date, Integer ore) {
		super();
		this.date = date;
		this.ore = ore;
	}

	public Date getData() {
		return date;
	}

	public void setData(Date data) {
		this.date = data;
	}

	public Integer getOre() {
		return ore;
	}

	public void setOre(Integer ore) {
		this.ore = ore;
	}
	
	

}

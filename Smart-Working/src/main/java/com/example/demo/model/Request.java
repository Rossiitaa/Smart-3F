package com.example.demo.model;

import java.sql.Date;

public class Request {
	
	private Date data;
	private Integer ore;
	
	public Request() {
		
	}

	public Request(Date data, Integer ore) {
		super();
		this.data = data;
		this.ore = ore;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getOre() {
		return ore;
	}

	public void setOre(Integer ore) {
		this.ore = ore;
	}
	
	

}

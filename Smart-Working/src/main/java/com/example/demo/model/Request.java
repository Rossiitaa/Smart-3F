package com.example.demo.model;

import java.time.LocalDate;

public class Request {
	
	private LocalDate date;
	private Integer hour;
	
	public Request() {
		
	}

	public Request(LocalDate date, Integer hour) {
		super();
		this.date = date;
		this.hour = hour;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getHour() {
		return hour;
	}

	public void setOre(Integer hour) {
		this.hour = hour;
	}
	
	

}

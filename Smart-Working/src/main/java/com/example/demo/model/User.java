package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

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
	private String firstname,lastname,email,phoneNumber,qualification,residency;
	private LocalDate academy_start_date,academy_end_date;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<User_State> user_states;
	
	
	public User() {
		
	}





	public LocalDate getAcademy_start_date() {
		return academy_start_date;
	}





	public void setAcademy_start_date(LocalDate academy_start_date) {
		this.academy_start_date = academy_start_date;
	}





	public LocalDate getAcademy_end_date() {
		return academy_end_date;
	}





	public void setAcademy_end_date(LocalDate academy_end_date) {
		this.academy_end_date = academy_end_date;
	}





	public User(String firstname, String lastname, String email, String phoneNumber, String qualification,
			String residency, LocalDate academy_start_date, LocalDate academy_end_date, List<User_State> user_states) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.qualification = qualification;
		this.residency = residency;
		this.academy_start_date = academy_start_date;
		this.academy_end_date = academy_end_date;
		this.user_states = user_states;
	}





	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public String getResidency() {
		return residency;
	}


	public void setResidency(String residency) {
		this.residency = residency;
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

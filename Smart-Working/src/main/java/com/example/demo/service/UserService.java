package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(long id,User user) {
		User u=userRepository.getReferenceById(id);
		u.setLastName(user.getLastName());
		u.setFirstName(user.getFirstName());
		u.setUser_states(user.getUser_states());
		u.setEmail(user.getEmail());
		u.setPhoneNumber(user.getPhoneNumber());
		u.setQualification(user.getQualification());
		u.setResidency(user.getResidency());
		u.setAcademyEndDate(user.getAcademyEndDate());
		u.setAcademyStartDate(user.getAcademyStartDate());
		u.setImageUrl(user.getImageUrl());
		u.setPassword(user.getPassword());
		u.setBirthDate(user.getBirthDate());
		u.setHasExperience(user.isHasExperience());
		u.setWorkExperiencePeriod(user.getWorkExperiencePeriod());
		return userRepository.save(u);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	public User updateUserImage(Long user_id, String img) {
		// TODO Auto-generated method stub
		User user = userRepository.getReferenceById(user_id);
		user.setImageUrl(img);
		userRepository.save(user);
		return user;
	}
	
	public User register(User user) {
		if (userExists(user.getEmail()) == null) {
			return userRepository.save(user);
		} else {
			throw new RuntimeException("L'utente e' gia' presente");
		}
	}
 
	public User userExists(String email) {
		return userRepository.findByEmail(email);
	}
 
	public User login(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
 
	}

	public Integer calcAge(Long user_id) {
		// TODO Auto-generated method stub
		User u = userRepository.getReferenceById(user_id);
		LocalDate now = LocalDate.now();
		Integer age = now.getYear() - u.getBirthDate().getYear();
		if( (u.getBirthDate().getMonthValue() > now.getMonthValue()) || (u.getBirthDate().getMonthValue() == now.getMonthValue() && u.getBirthDate().getDayOfMonth() > now.getDayOfMonth()))
			age-=1;
		return age;
	}
	
	
	
}

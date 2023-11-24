package com.example.demo.service;

import java.sql.Date;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Request;
import com.example.demo.model.State;
import com.example.demo.model.User;
import com.example.demo.model.UserStateKey;
import com.example.demo.model.User_State;
import com.example.demo.repository.StateRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserStateRepository;

@Service
public class UserStateService {

	@Autowired
	private UserStateRepository userStateRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private UserRepository userRepository;

	public List<User_State> getUserStates() {
		return userStateRepository.findAll();
	}

	public User_State saveUserState(Request request, Long user_id, Long state_id) {
		// TODO Auto-generated method stub
		State s = stateRepository.getReferenceById(state_id);
		User u = userRepository.getReferenceById(user_id);
		UserStateKey usk = new UserStateKey(user_id, state_id, request.getDate());
		User_State us = new User_State(usk, u, s);

		us.setOre(request.getHour());

		return userStateRepository.save(us);
	}

	public User_State updateUserState(Request request, Long user_id, Long state_id) {
		UserStateKey usk = new UserStateKey(user_id, state_id, request.getDate());
		User u = userRepository.getReferenceById(user_id);
		State s = stateRepository.getReferenceById(state_id);
		User_State us = userStateRepository.getReferenceById(usk);
		us.setState(s);
		us.setUser(u);
		us.setOre(request.getHour());
		return userStateRepository.save(us);
	}

	public void deleteUserState(Request request, Long user_id, Long state_id) {
		UserStateKey usk = new UserStateKey(user_id, state_id, request.getDate());
		userStateRepository.deleteById(usk);
	}

	public List<User> getAllAbsentByDate(Date date) {
		// TODO Auto-generated method stub
		State s = stateRepository.getReferenceById((long) 1);
		List<User_State> us = userStateRepository.findAllByState(s);

		List<User> usdate = new ArrayList<User>();

		for (User_State u : us) {
			if (u.getId().getDate().equals(date))
				usdate.add(u.getUser());
		}

		return usdate;
	}

	public List<User> getAllSmartByDate(Date date) {

		State s = stateRepository.getReferenceById((long) 2);

		List<User_State> us = userStateRepository.findAllByState(s);

		List<User> user = new ArrayList<User>();

		for (User_State u : us) {
			if (u.getId().getDate().equals(date)) {
				user.add(u.getUser());
			}

		}
		return user;
	}

	public List<User> getAllAbsent() {
		// TODO Auto-generated method stub

		State s = stateRepository.getReferenceById((long) 1);

		List<User_State> us = userStateRepository.findAllByState(s);

		List<User> user = new ArrayList<User>();

		for (User_State u : us) {
			user.add(u.getUser());

		}
		return user;
	}

	public List<User> getAllSmart() {
		// TODO Auto-generated method stub
		State s = stateRepository.getReferenceById((long) 2);

		List<User_State> us = userStateRepository.findAllByState(s);

		List<User> user = new ArrayList<User>();

		for (User_State u : us) {
			user.add(u.getUser());
		}
		return user;
	}

	public int getMonthlyAbsenceHoursByUser(Long user_id, YearMonth yearmonth) {
		State s = stateRepository.getReferenceById((long) 1);

		List<User_State> us = userStateRepository.findAllByState(s);
		int tot = 0;

		for (User_State u : us) {
			if (u.getId().getUserid() == user_id && u.getId().getDate().getYear() == yearmonth.getYear()
					&& u.getId().getDate().getMonth() == yearmonth.getMonth()) {
				tot += u.getOre();
			}
		}
		return tot;
	}

	public int getMonthlySmartByUserHours(Long user_id, YearMonth yearmonth) {
		State s = stateRepository.getReferenceById((long) 2);

		List<User_State> us = userStateRepository.findAllByState(s);
		int tot = 0;

		for (User_State u : us) {
			if (u.getId().getUserid() == user_id && u.getId().getDate().getYear() == yearmonth.getYear()
					&& u.getId().getDate().getMonth() == yearmonth.getMonth()) {
				tot += u.getOre();
			}
		}
		return tot;
	}

	public List<Object> getMonthlySmartByUser(long user_id, int month) {

		return userStateRepository.getMonthlySmartByUser(user_id, month);
	}

	public List<Object> getMonthlyAbsenceByUser(long user_id, int month) {

		return userStateRepository.getMonthlyAbsenceByUser(user_id, month);
	}

	// conta le ore di assenza di una persona nel singolo mese
	// conta le ore di smart di una persona nel singolo mese

}

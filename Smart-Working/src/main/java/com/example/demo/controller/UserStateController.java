package com.example.demo.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Request;
import com.example.demo.model.User;
import com.example.demo.model.User_State;
import com.example.demo.service.UserStateService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserStateController {
	
	@Autowired
	private UserStateService userStateService;
	
	@GetMapping("/getUserStates")
	public List<User_State> getUserStates(){ 
		return userStateService.getUserStates();
	}
	
	@PostMapping("/saveUserState/{user_id}/{state_id}")
	public User_State saveUserState(@RequestBody Request request, @PathVariable Long user_id, @PathVariable Long state_id) {
		return userStateService.saveUserState(request, user_id, state_id);
	}
	
	@PutMapping("/updateUserState/{user_id}/{state_id}")
	public User_State updateUserState(@RequestBody Request request, @PathVariable Long user_id, @PathVariable Long state_id) {
		return userStateService.updateUserState(request, user_id, state_id);
	}
	
	@DeleteMapping("/deleteUserState/{user_id}/{state_id}")
	public void deleteUserState(@RequestBody Request request, @PathVariable Long user_id, @PathVariable Long state_id) {
		userStateService.deleteUserState(request,user_id, state_id);
	}
	
	@GetMapping("/getAllAbsentsByDate/{date}")
	public List<User> getAllAbsentsByDate(@PathVariable Date date){
		return userStateService.getAllAbsentByDate(date);
	}
	
	@GetMapping("/getAllAbsentsByDateCustom/{date}")
	public List<Object> getAllAbsentsByDateCustom(@PathVariable Date date){
		return userStateService.getAllAbsentByDateCustom(date);
	}
	

	@GetMapping("/getAllSmartByDate/{date}")
	public List<User> getAllSmartByDate(@PathVariable Date date){
		return userStateService.getAllSmartByDate(date);
	}
	
	@GetMapping("/getAllSmartByDateCustom/{date}")
	public List<Object> getAllSmartByDateCustom(@PathVariable Date date){
		return userStateService.getAllSmartByDateCustom(date);
	}
	
	@GetMapping("/getAllAbsent")
	public List<User> getAllAbsent(){
		return userStateService.getAllAbsent();
	}
	
	
	
	@GetMapping("/getAllSmart")
	public List<User> getAllSmart(){
		return userStateService.getAllSmart();
	}
	
	@GetMapping("/getMonthlyAbsenceHoursByUser/{user_id}/{year}-{month}")
	public int getMonthlyAbsenceHoursByUser(@PathVariable Long user_id, @PathVariable Integer year,@PathVariable Integer month) {
		YearMonth yearmonth = YearMonth.of(year,month);	
		return userStateService.getMonthlyAbsenceHoursByUser(user_id,yearmonth);
	}
	
	@GetMapping("/getMonthlySmartHoursByUser/{user_id}/{year}-{month}")
	public int getMonthlySmartHoursByUser(@PathVariable Long user_id, @PathVariable Integer year,@PathVariable Integer month) {
		YearMonth yearmonth = YearMonth.of(year,month);	
		return userStateService.getMonthlySmartByUser(user_id,yearmonth);
	}
	

}
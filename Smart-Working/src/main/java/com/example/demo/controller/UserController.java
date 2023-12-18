package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LoginRequest;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getUsers")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@PutMapping("/updateUser/{id}")
	public User updateUser(@RequestBody User user,@PathVariable long id) {
		return userService.updateUser(id ,user);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	
	@PatchMapping("/updateUserImage/{user_id}")
	public User updateUserImage(@PathVariable Long user_id, @RequestBody String img) {
		return userService.updateUserImage(user_id,img);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user) {
		try {
			userService.register(user);
			return ResponseEntity.ok("L'utente è stato aggiunto con successo");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore durante la registrazione dell'utente");
			
		}
	}
 
	@GetMapping("/login")
	public User login(@RequestBody LoginRequest login) {
		return userService.login(login.getEmail(), login.getPassword());
		
	}
	
	@GetMapping("/calculateAgeById/{user_id}")
	public Integer calcAge(@PathVariable Long user_id) {
		return userService.calcAge(user_id);
	}
	
	

}

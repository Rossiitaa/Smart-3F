package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserStateKey;
import com.example.demo.model.User_State;

@Repository
public interface UserStateRepository extends JpaRepository<User_State, UserStateKey>{
	
}

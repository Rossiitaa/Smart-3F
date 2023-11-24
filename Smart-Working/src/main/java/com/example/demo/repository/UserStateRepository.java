package com.example.demo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.State;
import com.example.demo.model.UserStateKey;
import com.example.demo.model.User_State;

@Repository
public interface UserStateRepository extends JpaRepository<User_State, UserStateKey>{

	

	List<User_State> findAllByState(State state);
	

	@Query(value = "SELECT firstname,lastname,date \r\n"
			+ "FROM user \r\n"
			+ " INNER JOIN user_state ON user.user_id = user_state.user_id\r\n"
			+ " INNER JOIN state ON user_state.state_id = state.state_id\r\n"
			+ "WHERE state.state='ASSENZA' AND user_state.date = :date", nativeQuery = true)
	List<Object> findAllAbsentByDateCustom(@Param("date") Date date);
	
	@Query(value = "SELECT firstname,lastname,date \r\n"
			+ "FROM user \r\n"
			+ " INNER JOIN user_state ON user.user_id = user_state.user_id\r\n"
			+ " INNER JOIN state ON user_state.state_id = state.state_id\r\n"
			+ "WHERE state.state='SMART_WORKING' AND user_state.date = :date", nativeQuery = true)
	List<Object> findAllSmartByDateCustom(@Param("date") Date date);
	
	
	
	

	
	@Query(value="select user.*, user_state.date from user JOIN user_state ON user_state.user_id = user.user_id \r\n"
			+ "WHERE MONTH(date) = :month AND user_state.state_id='2' AND user.user_id = :user_id", nativeQuery=true)
	List<Object> getMonthlySmartByUser(@Param(value="user_id") long user_id , @Param(value="month") int month);
	
	@Query(value="select user.*, user_state.date from user JOIN user_state ON user_state.user_id = user.user_id \r\n"
			+ "WHERE MONTH(date) = :month AND user_state.state_id='1' AND user.user_id = :user_id", nativeQuery=true)
	List<Object> getMonthlyAbsenceByUser(@Param(value="user_id") long user_id , @Param(value="month") int month);


	
}


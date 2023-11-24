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

	
	@Query(value="SELECT u.nome, u.cognome FROM User u " +
	        "INNER JOIN User_State us ON u.user_id = us.user_id " +
	        "INNER JOIN State s ON us.state_id = s.state_id " +
	        "WHERE us.date = :date AND s.state = 'ASSENZA'", nativeQuery = true)
	List<User_State> findAllAbsentByDate(@Param("date") Date date);

	List<User_State> findAllByState(State state);

	
	@Query(value="select user.*, user_state.date from user JOIN user_state ON user_state.user_id = user.user_id \r\n"
			+ "WHERE MONTH(date) = :month AND user_state.state_id='2' AND user.user_id = :user_id", nativeQuery=true)
	List<Object> getMonthlySmartByUser(@Param(value="user_id") long user_id , @Param(value="month") int month);
	
	@Query(value="select user.*, user_state.date from user JOIN user_state ON user_state.user_id = user.user_id \r\n"
			+ "WHERE MONTH(date) = :month AND user_state.state_id='1' AND user.user_id = :user_id", nativeQuery=true)
	List<Object> getMonthlyAbsenceByUser(@Param(value="user_id") long user_id , @Param(value="month") int month);


	
}


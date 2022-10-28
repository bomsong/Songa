package com.Sahithi.app.RestAPI.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sahithi.app.RestAPI.Expense.Expenses;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{

	
	Boolean existsByEmail(String Email);
	
	Optional<User>  findByNameContaining(String name);
	

	
	
}

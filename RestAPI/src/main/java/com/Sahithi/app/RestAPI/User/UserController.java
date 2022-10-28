package com.Sahithi.app.RestAPI.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Sahithi.app.RestAPI.Expense.Expenses;

@RestController
public class UserController {

	@Autowired
	private UserService userservice;


	@PostMapping("/register1")
	public ResponseEntity<User> saveuser(@RequestBody User user) {
	
		return new ResponseEntity<User>(userservice.createUser(user),HttpStatus.CREATED);
		
		
	}
	

	@GetMapping("/user1/{id}")
	
	public User Readuser(@PathVariable Long id) {

	return userservice.ReadById(id);
	
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

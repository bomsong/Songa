package com.Sahithi.app.RestAPI.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.Sahithi.app.RestAPI.Expense.Expenses;

@Service
public class UserServiceImpl implements UserService {

	private static final String id = null;
	@Autowired
	private UserRepository userrepo;


	
	public User createUser(User user) {
		if(userrepo.existsByEmail(user.getEmail())){
			
		throw new ItemAlreadyExistException ("User os already registsered with email:"+user.getEmail());	
		}
				
	User newUser= new User();
	BeanUtils.copyProperties(user, newUser);
		return userrepo.save(user);
	}


public User ReadById(Long id) {
		
Optional <User> user= userrepo.findById(id);

if (user.isPresent()) {

return user.get();
}
else

throw new RuntimeException("User is not found for the id" +id);

}










}





	
	

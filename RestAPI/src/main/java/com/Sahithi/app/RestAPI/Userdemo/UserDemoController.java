package com.Sahithi.app.RestAPI.Userdemo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserDemoController {
	
	@Autowired
	private UserRepo userrepo;
	
	
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	
	@GetMapping("/userdemo")
	public String getPage() {
		return "Welcome to Registration Page";
		
	}

	
	@PostMapping("/saveuser")
public Userdemo saveUserdemo(@RequestBody Userdemo userdemo) {
	return userrepo.save(userdemo);
	
	
	
	
}
	 @GetMapping(path="/all")
	  public @ResponseBody Iterable<Userdemo> getAllUsers() {
	    // This returns a JSON or XML with the users
	    return userrepo.findAll();
	  }
	
	
	 @GetMapping("/user/{id}")
	public Optional<Userdemo> getbyid(@PathVariable Long id) {
		return userrepo.findById(id);
		
	 }
	 
	 
	 @GetMapping("/user")
		public Optional<Userdemo> getbyfirstname(@RequestParam("id") Long id) {
			return userrepo.findById(id);
			
		 }
	
	 
	 
	 
	 
	 
	 
	
}

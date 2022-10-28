package com.Sahithi.app.RestAPI.Userdemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Userdemo {
	@Id
	private Long id;
	@Column
	private String email;
	@Column
	private String firstname;
	@Column
	private String lastname;
	
	
	
	public Userdemo(Long id, String email, String firstname, String lastname) {
		super();
		this.id = id;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	
	
	public Userdemo() {
		super();
	}



	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	

	
	

	
	
	
	
	
	
	
	
	
	
	
	
}

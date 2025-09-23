package com.spring.core.tasks;

import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceImpl implements AccountService{
	
	
	UserService userservice ;
	
	
	@Autowired
	public AccountServiceImpl(UserService userservice) {
		this.userservice = userservice ;
	}
	
	
	
	
	
	
	@Override
	public void getSavePerson(String name) {
		
		userservice.save(name);
	}
	
	
	

}

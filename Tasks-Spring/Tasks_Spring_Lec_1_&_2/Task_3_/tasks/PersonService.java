package com.spring.core.tasks;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class PersonService implements UserService{

	String name;

	boolean connection ;
	
	@PostConstruct
	void openConnection() {
		connection = true;
		System.out.println("Open Connection");

	}
	
	@PreDestroy
	void closeConnection() {
		connection = false;
		System.out.println("Close Connection");
		
		
	}
	
	@Override
	public void save(String name) {
		this.name = name;		
	}
	
	
	@Override
	public void printName() {
		System.out.println("Person_Name_is : " + name);
		
	}
	


}

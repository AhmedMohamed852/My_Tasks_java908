package com.spring.core.tasks;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class PersonService implements UserService{

	String name;

	@Override
	public void save(String name) {
		this.name = name;	
		System.out.println("Save Person : " + name);
	}
	
	

	


}

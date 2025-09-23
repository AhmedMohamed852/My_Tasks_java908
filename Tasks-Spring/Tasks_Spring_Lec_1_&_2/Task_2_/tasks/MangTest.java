package com.spring.core.tasks;

public class MangTest implements UserService {

	String name;

	
	
	@Override
	public void save(String name) {
		this.name = name;	
		System.out.println("Save Mang " + name);
	}
	

	

}

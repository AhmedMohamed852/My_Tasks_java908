package com.spring.core.tasks;

public class MangerService implements UserService {
	String name;

	@Override
	public void save(String name) {
		this.name = name;
		
	}

	@Override
	public void update(String name) {
		this.name = name;
		
	}

	public void printName() {
		System.out.println("manger_Name_is : " + name);
		
	}

}

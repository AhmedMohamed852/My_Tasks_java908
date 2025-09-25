package com.hibernate.model.teasks;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Check;
@Entity
@Check(constraints = "age BETWEEN 15 AND 20")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id ;
	@Column(name = "name",length = 50)
	String name;
	@Column(name = "age",nullable = false)
	int age;
	@Column(name = "address",unique = true)
	String address;
	public Teacher(String name  , int age , String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	
	
}

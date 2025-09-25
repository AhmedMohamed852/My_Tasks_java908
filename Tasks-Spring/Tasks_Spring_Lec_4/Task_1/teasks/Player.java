package com.hibernate.model.teasks;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Check;
@Entity
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	@Column(name = "name",nullable = false)
	private String name ;
	@Column(name = "age",length = 10)
	private int age;
	private boolean status;
	public Player(String name, int age, boolean status) {
		this.name = name;
		this.age = age;
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", age=" + age + ", status=" + status + "]";
	}
	
	
	


	
	
}

package com.hibernate.model.teasks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class DoctorDetails {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	
	private String fukkAddress;
	private String firstName;
	private String lastName;
	private int age;
	
//______________________________________________________

	
	@OneToOne
	@JoinColumn(name = "doctor_id" ,nullable = false ,unique = true)
	Doctor doctor;
	
	
//______________________________________________________

	
	





	public String getFukkAddress() {
		return fukkAddress;
	}




	public DoctorDetails(String fukkAddress, String firstName, String lastName, int age, Doctor doctor) {
	super();
	this.fukkAddress = fukkAddress;
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
	this.doctor = doctor;
}




	public void setFukkAddress(String fukkAddress) {
		this.fukkAddress = fukkAddress;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public int getAge() {
		return age;
	}




	public void setAge(int age) {
		this.age = age;
	}




	@Override
	public String toString() {
		return "DoctorDetails [id=" + id + ", fukkAddress=" + fukkAddress + ", firstName=" + firstName + ", lastName="
				+ lastName + ", age=" + age + "]";
	}
	
	
	
	
	

}

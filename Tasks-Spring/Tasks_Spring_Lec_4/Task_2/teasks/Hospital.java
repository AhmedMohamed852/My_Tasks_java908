package com.hibernate.model.teasks;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Check;
@Entity
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	private String name;
	private int numberOfDoctors;
	private int numberOfPatient;
	
//______________________________________________________

	@OneToMany(mappedBy = "hospital" ,  cascade = CascadeType.ALL)
	List<Doctor> doctors = new ArrayList<>();
	
	
	
	
//______________________________________________________

	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfDoctors() {
		return numberOfDoctors;
	}
	public void setNumberOfDoctors(int numberOfDoctors) {
		this.numberOfDoctors = numberOfDoctors;
	}
	public int getNumberOfPatient() {
		return numberOfPatient;
	}
	public void setNumberOfPatient(int numberOfPatient) {
		this.numberOfPatient = numberOfPatient;
	}
	
	public Hospital(String name, int numberOfDoctors, int numberOfPatient) {
		super();
		this.name = name;
		this.numberOfDoctors = numberOfDoctors;
		this.numberOfPatient = numberOfPatient;
	}
	public List<Doctor> getDoctors() {
		return doctors;
	}

	
	
	
	
	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", numberOfDoctors=" + numberOfDoctors + ", numberOfPatient="
				+ numberOfPatient + "]";
	}
	
	
	


	
	
}

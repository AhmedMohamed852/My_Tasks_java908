package com.hibernate.model.teasks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Patient {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	private String name ;
	private String typeOfDisease;
//______________________________________________________

    @ManyToOne
    @JoinColumn(name = "doctor_id" ,nullable = false)
    private Doctor doctor;
	
	
	
	
//______________________________________________________

	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getTypeOfDisease() {
		return typeOfDisease;
	}



	public void setTypeOfDisease(String typeOfDisease) {
		this.typeOfDisease = typeOfDisease;
	}



	public Patient( String name, String typeOfDisease, Doctor doctor) {
		this.name = name;
		this.typeOfDisease = typeOfDisease;
		this.doctor = doctor;
	}



	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", typeOfDisease=" + typeOfDisease + "]";
	}



	
	
	
	
	
	
	
}

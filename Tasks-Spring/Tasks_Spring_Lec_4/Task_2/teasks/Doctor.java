package com.hibernate.model.teasks;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Doctor {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	private String SuserName;
	private double salary;
	
//______________________________________________________
	
	@OneToOne(mappedBy = "doctor" ,  cascade = CascadeType.ALL)
	DoctorDetails doctorDetails;
	
	@ManyToOne
	@JoinColumn(name = "hospital_id" ,nullable = false)
	private Hospital hospital;
	
	
	@OneToMany(mappedBy = "doctor" ,  cascade = CascadeType.ALL)
	List<Patient> patients = new ArrayList<>();
	
	
	
//______________________________________________________

	
	
	
	
	public DoctorDetails getDoctorDetails() {
		return doctorDetails;
	}
	
	
	public void setDoctorDetails(DoctorDetails doctorDetails) {
		this.doctorDetails = doctorDetails;
	}
	
	
	public Hospital getHospital() {
		return hospital;
	}
	
	
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	
	public List<Patient> getPatients() {
		return patients;
	}
	
	
	public String getSuserName() {
		return SuserName;
	}
	
	public Doctor(String suserName, double salary , Hospital hospital) {
	super();
	SuserName = suserName;
	this.salary = salary;
	this.hospital = hospital;
}
	
	public void setSuserName(String suserName) {
		SuserName = suserName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Doctor [id=" + id + ", SuserName=" + SuserName + ", salary=" + salary + 
				 "]";
	}
	
	
	

}

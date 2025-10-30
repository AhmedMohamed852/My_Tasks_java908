package com.hospital.service;

import java.util.List;

import com.hospital.model.Hospital;

public interface Hospital_Service {
	
	List<Hospital> getAllDoctorsWithPatient ();
	boolean addPatient (Hospital patient);

}

package com.hibernate.model.teasks;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.teasks.Doctor;
import com.hibernate.model.teasks.DoctorDetails;
import com.hibernate.model.teasks.Hospital;
import com.hibernate.model.teasks.Patient;



public class Main {

	public static void main(String[] args) {

         Configuration configuration = new Configuration().addAnnotatedClass(Hospital.class)
		.addAnnotatedClass(Doctor.class)
		.addAnnotatedClass(DoctorDetails.class)
		.addAnnotatedClass(Patient.class).configure("hibernate.cfg.xml");
         
        SessionFactory sessionfactory = configuration.buildSessionFactory();
        Session session = sessionfactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        

        Hospital hospital = new Hospital("Al_Salam", 30, 100);
        
       System.out.println(hospital.toString());   
       
        Doctor doctor1 = new Doctor("Moaaz", 30000, hospital);
        Doctor doctor2 = new Doctor("Hamza", 30000, hospital);
        

        hospital.getDoctors().add(doctor1);
        hospital.getDoctors().add(doctor2);
        
            

      

        DoctorDetails details1 = new DoctorDetails("Cairo", "Moaaz", "Badr", 20, doctor1);
        DoctorDetails details2 = new DoctorDetails("Cairo", "Hamza", "Badr", 20, doctor2);
        
        doctor1.setDoctorDetails(details1);
        doctor2.setDoctorDetails(details2);
        
       

        
        Patient patient1 = new Patient("Ahmed", "My head hurts", doctor1);
        Patient patient2 = new Patient("Ahmed", "My head hurts", doctor1);
        Patient patient3 = new Patient("Ahmed", "My head hurts", doctor2);
        
        doctor1.getPatients().add(patient1);
        doctor1.getPatients().add(patient2);
        doctor2.getPatients().add(patient3);

        
        session.save(hospital);
        

        
		transaction.commit();
		 

		sessionfactory.close();
		
        					
        					
        					
        					
        					
        					
        					
        					
        					
        					
		
        
	}

}

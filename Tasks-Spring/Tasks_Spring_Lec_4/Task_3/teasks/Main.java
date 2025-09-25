package com.hibernate.model.teasks;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.teasks.Doctor;

import com.hibernate.model.teasks.Patient;



public class Main {

	public static void main(String[] args) {

         Configuration configuration = new Configuration().addAnnotatedClass(Student.class)
        		 .addAnnotatedClass(Passport.class)
        		 .addAnnotatedClass(Patient.class)
        		 .addAnnotatedClass(Order.class)
        		 .addAnnotatedClass(Employee.class)
        		 .addAnnotatedClass(Doctor.class)
        		 .addAnnotatedClass(Department.class)
        		 .addAnnotatedClass(Book.class)
        		 .addAnnotatedClass(Customer.class)
        		 .addAnnotatedClass(Author.class).
        		 configure("hibernate.cfg.xml");
         
        SessionFactory sessionfactory = configuration.buildSessionFactory();
        Session session = sessionfactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        

  
        

        
		transaction.commit();
		 

		sessionfactory.close();
		
        					
        					
        					
        					
        					
        					
        					
        					
        					
        					
		
        
	}

}

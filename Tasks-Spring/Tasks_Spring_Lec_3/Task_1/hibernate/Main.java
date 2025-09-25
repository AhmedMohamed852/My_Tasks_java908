package com.java.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.teasks.Teacher;


public class Main {

	public static void main(String[] args) {

        Configuration configuration = new Configuration().addAnnotatedClass(Teacher.class).configure("hibernate.cfg.xml");
        SessionFactory sessionfactory = configuration.buildSessionFactory();
        Session session = sessionfactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        


        Teacher teacher = new Teacher("@.AHME~D" , 20 ,"NewCairo");
		session.save(teacher);
		transaction.commit();
	
		sessionfactory.close();
		
        					
        					
        					
        					
        					
        					
        					
        					
        					
        					
		
        
	}

}

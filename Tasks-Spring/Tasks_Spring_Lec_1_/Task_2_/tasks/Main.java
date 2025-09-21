package com.spring.core.tasks;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.ApplicationServiceImpl;
import com.spring.core.SpringConfig;

public class Main {

	public static void main(String[] args) {

		
	ClassPathXmlApplicationContext applicationContext1 = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	
	
	
	  System.out.println("_______ Container xml _______");
	  

	  AccountServiceImpl accountService1 = applicationContext1.getBean("account" ,AccountServiceImpl.class);
	
	  accountService1.getSavePerson("@hme_d");

 //__________________________________________________________
	 
		System.out.println("\n");
		
 //__________________________________________________________
 
 
		System.out.println("_______ container java no xml _______");

		
		  AnnotationConfigApplicationContext applicationContext2 = new
		  AnnotationConfigApplicationContext(SpringConfiguration.class);
		  
		  AccountServiceImpl accountService2 = applicationContext2.getBean("account" ,AccountServiceImpl.class);
		  accountService2.getSavePerson("@hme_d");

	 
	
	}

}

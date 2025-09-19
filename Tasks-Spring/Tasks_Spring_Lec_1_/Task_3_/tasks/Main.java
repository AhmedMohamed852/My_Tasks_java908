package com.spring.core.tasks;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.SpringConfig;

public class Main {

	public static void main(String[] args) {

		
	ClassPathXmlApplicationContext applicationContext1 = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	
	
	
	  System.out.println("_______ Container xml _______");
	  
	  UserService personService1 = applicationContext1.getBean("person" ,PersonService.class);
	  UserService personService2 = applicationContext1.getBean("person" , PersonService.class);
	  UserService personService3 = applicationContext1.getBean("person" , PersonService.class);
	  
	  personService1.save("Ahmed");
	  personService1.printName();
	  
	  applicationContext1.close();
	
	

 //__________________________________________________________
	 
		System.out.println("\n");
		
 //__________________________________________________________
 
 
		System.out.println("_______ container java no xml _______");

		
		  AnnotationConfigApplicationContext applicationContext2 = new
		  AnnotationConfigApplicationContext(SpringConfiguration.class);
		 
		  UserService personService4 =applicationContext2.getBean("person" , PersonService.class);
		  UserService personService5 =applicationContext2.getBean("person" , PersonService.class);
		  UserService personService6 =applicationContext2.getBean("person" , PersonService.class);
	 
	
		  personService4.save("Mohamed");
			personService4.printName();


	

		applicationContext2.close();
		
		
		
		
	}

}

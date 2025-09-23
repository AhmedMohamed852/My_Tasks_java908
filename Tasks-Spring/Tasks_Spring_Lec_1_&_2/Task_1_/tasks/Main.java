package com.spring.core.tasks;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.SpringConfig;

public class Main {

	public static void main(String[] args) {

		
	ClassPathXmlApplicationContext applicationContext1 = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	
	
	System.out.println("_______ Container xml _______");

	 MangerService mangerService1 =applicationContext1.getBean("manger" , MangerService.class);
	 PersonService personService1 =applicationContext1.getBean("person" , PersonService.class);
	 
	 mangerService1.save("Ahmed");
	 mangerService1.printName();
	 
	System.out.println("After_Update");
	
	 mangerService1.update("Mohamed");
	 mangerService1.printName();
	
		System.out.println("\n");
	 
	 personService1.save("Omar");
	 personService1.printName();
	 
	System.out.println("After_Update");
	
	personService1.update("Hamza");
	personService1.printName();
 //__________________________________________________________
	 
		System.out.println("\n");
		
 //__________________________________________________________
 
 
		System.out.println("_______ container java no xml _______");

	 AnnotationConfigApplicationContext applicationContext2 = 
			 new AnnotationConfigApplicationContext(SpringConfig.class);
	
	 MangerService mangerService2 =applicationContext2.getBean("manger" , MangerService.class);
	 PersonService personService2=applicationContext2.getBean("person" , PersonService.class);
	 
	 mangerService2.save("Yaser");
	 mangerService2.printName();
	 
	System.out.println("After_Update");
	
	 mangerService2.update("Moaaz");
	 mangerService2.printName();	
	 
		System.out.println("\n");

	 personService2.save("Omar");
	 personService2.printName();
	 
	System.out.println("After_Update");
	
	personService2.update("Hamza");
	personService2.printName();
		
		
		
		
		
	}

}

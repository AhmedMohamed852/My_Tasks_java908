package com.spring.core.tasks;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.spring.core.tasks")
public class SpringConfiguration {
	
	@Bean("manger")
	public MangerService mangerService()
	{
		return new MangerService();
	}
	
	
	
	@Bean("person")
	public PersonService personService()
	{
		return new PersonService();
	}

}

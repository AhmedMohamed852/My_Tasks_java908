package com.spring.core.tasks;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.spring.core.tasks")
public class SpringConfiguration {
	

    @Bean
    public UserService personService() {
        return new PersonService();
    }
    
    @Bean
    public UserService mang() {
    	return new MangTest();
    }

	@Bean("account")
	public AccountServiceImpl accountServiceImpl() {
        return new AccountServiceImpl(personService());	
        
	}
	
	

}

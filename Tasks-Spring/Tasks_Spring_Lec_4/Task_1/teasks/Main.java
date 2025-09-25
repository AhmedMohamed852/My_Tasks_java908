package com.java.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.teasks.Player;


public class Main {

	public static void main(String[] args) {

        Configuration configuration = new Configuration().addAnnotatedClass(Player.class).configure("hibernate.cfg.xml");
        SessionFactory sessionfactory = configuration.buildSessionFactory();
        Session session = sessionfactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        


        Player player = new Player("@.AHME~D" , 20 , true);
		session.save(player);
		System.out.println(player.toString());
		
		player.setName("Mohamed");
		player.setAge(40);
		player.setStatus(false);
		session.update(player);
		System.out.println(player.toString());
		
		session.delete(player);
		
		 player = session.get(Player.class, player.getId());

		 
		Player player2 = session.get(Player.class, player.getId());
		System.out.println(player2);
		
		
		transaction.commit();

		sessionfactory.close();
		
        					
        					
        					
        					
        					
        					
        					
        					
        					
        					
		
        
	}

}

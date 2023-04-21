package com.CRUD.SecondCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main( String[] args )    {
    	
    	Student s1 = new Student();
    	s1.setName("Mohit");
    	s1.setCity("Mumabi");
    	
    	SessionFactory factory = new Configuration().configure("config.xml").buildSessionFactory();
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	
    	session.save(s1);
   
    	
    	tx.commit();
    	session.close();
    	factory.close();
    }
}

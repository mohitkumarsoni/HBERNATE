package com.LifeCycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("cofig.xml").buildSessionFactory();
		
		//creating student object
		Student s1 = new Student();
		s1.setId(21);
		s1.setName("mohit soni");
		//s1 : Transient state
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();		
		session.save(s1);
		//s1 : Persistent state - session,database
		
		s1.setName("Mohitkumar Soni");		
		tx.commit();	//you can change any details of object before commitment & it also will be updated in database. Once committed, details in database will not be updated
		
		
		s1.setName("Chota Don");
		
		session.close();	// session.close() will disconnect link with database
		//s1 : Detached state
		factory.close();
		
		System.out.println(s1.getName());//this will show last updated name in console, but that wont be seen in database because object is already committed.
	}
}

/*
 * Transient : value not registered in database
 * Persistent : value present in both object & database(will sync modified value in database after saving, without commit()  )
 * Detached : 
 * Removed : value removed from database
 * 
 */


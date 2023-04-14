package com.Git.gitHubHibernate;

import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) throws IOException {
		Configuration cnf = new Configuration();
		cnf.configure("cofig.xml");
		SessionFactory factory = cnf.buildSessionFactory();
		
		Student student = new Student();
		Address address = new Address();
		
		student.setId(1);
		student.setNameString("Mohitkumar soni");
		student.setCityString("Mumbai");
		
		//address.setId() will be generated automatically because of @GeneratedValue
		address.setStreet("Marine Drive");
		address.setCity("Mumbai");
		address.setOpen(true);
		address.setX(12.33); 		//wont be saved in database because of @Transient
		address.setDate(new Date());	//will set current date because of @Temporal
		
		
		
		
		Session session = factory.openSession();	
		Transaction tx = session.beginTransaction(); 	
		
		session.save(student);
		session.save(address);
		
		tx.commit();		
		factory.close();
	}
}

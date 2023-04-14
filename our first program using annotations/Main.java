package com.Git.gitHubHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		Configuration cnf = new Configuration();
		cnf.configure("cofig.xml");
		SessionFactory factory = cnf.buildSessionFactory();
		
		Student student = new Student();
		student.setId(1);
		student.setNameString("mohitkumar soni");
		student.setCityString("Mumbai");
		
		Session session = factory.openSession();	//factory.getCurrentSession() will be used when there is already some sessions will be opened
		Transaction tx = session.beginTransaction(); 	//object tx will make physical changes in database
		
		session.save(student);
		tx.commit();
		
		factory.close();
	}
}

package com.Git.gitHubHibernate;

import java.io.IOException;

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
		Certificate certificate = new Certificate();
		
		student.setNameString("Mohitkumar Soni");
		student.setCityString("Mumbai");
		certificate.setCourse("Android");
		certificate.setDuration("4 months");
		student.setCertified(certificate);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(student);
		tx.commit();
		
		session.close();
		factory.close();
	}
}

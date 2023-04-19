package com.fetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		
		Student student1 = new Student();
		Student student2 = new Student();
		Student student3 = new Student();
		Certificate c1 = new Certificate();
		Certificate c2 = new Certificate();
		Certificate c3 = new Certificate();
		
		
		c1.setCourse("android");
		c1.setDuration("3 month");
		
		c2.setCourse("java");
		c2.setDuration("2 month");
		
		c3.setCourse("python");
		c3.setDuration("5 month");
		
		
		student1.setNameString("Mohit");
		student1.setCertificate(c1);
		
		student2 .setNameString("ravi");
		student2.setCertificate(c2);
		
		student3.setNameString("rasiks");
		student3.setCertificate(c3);
		
		
		
		SessionFactory factory = new Configuration().configure("configure.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		
		session.save(student1);
		session.save(student2);
		session.save(student3);
		
		tx.commit();
		session.close();
		factory.close();
		
	}
}

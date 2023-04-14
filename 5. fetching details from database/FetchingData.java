package com.Git.gitHubHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchingData {
	public static void main(String[] args) {
		Configuration cnf = new Configuration();
		cnf.configure("cofig.xml");
		SessionFactory factory = cnf.buildSessionFactory();
		
		Student student = new Student();
		Address address = new Address();
		
		Session session = factory.openSession();	//open session to connect with database
		
		student = (Student)session.get(Student.class, 1);	//get student details in student object
		address = (Address)session.get(Address.class, 1);	//get address details in address object
		
		System.out.println(student);	//print all details
		System.out.println(address);	//print all details 
		
		System.out.println(student.getNameString());	//get specific detail of student
		System.out.println(address.getStreet());		//get specific detail of address
		
	}
}

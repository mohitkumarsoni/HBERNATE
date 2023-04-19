package com.Pegination;


import org.hibernate.query.*;

import com.fetch.Student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQL_Pegination {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("configure.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Query query = session.createQuery("from Student");
		
		//implementing pegination using hibernate
		
		query.setFirstResult(4);
		query.setMaxResults(3);
		
		List<Student> list = query.list();
		for(Student student : list) {
			System.out.println(student.getId()+":"+student.getNameString()+":"+student.getCertificate().getCourse());
		}
		
		session.close();
		factory.close();
	
	
	}
}
//===================== pegination is setting limit for the result we want to print on the page =================
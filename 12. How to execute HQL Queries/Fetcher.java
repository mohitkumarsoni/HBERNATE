package com.fetch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetcher {
	public static void main(String[] args) throws IOException {
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("enter id to get detail");
//		int id  = Integer.parseInt(br.readLine());
//		
//		SessionFactory factory = new Configuration().configure("configure.xml").buildSessionFactory();
//		Session session = factory.openSession();
//		
//		String qString = "from Student where id=:x";
//		Query query = session.createQuery(qString);
//		query.setParameter("x", id);
//		
//		List<Student> studentList = query.list();
//		for(Student s1 : studentList) {
//			System.out.println(s1.getNameString()+": "+s1.getCertificate().getCourse());
//		}
//		================= TYPE 1 =============================
		
		
		
		
		
		
//		SessionFactory factory = new Configuration().configure("configure.xml").buildSessionFactory();
//		Session session = factory.openSession();
//		
//		
//		String qString = "from Student";
//		Query query = session.createQuery(qString);
//		
//		List<Student> list = query.list();
//		
//		System.out.println("=======================");
//		for(Student s1 : list) {
//			System.out.println(s1);
//		}
//		System.out.println("====================");
//	
//		================ TYPE 2 ============================
		
		
		
		
		
		SessionFactory factory = new Configuration().configure("configure.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		
		String qString = "from Student where id=2";
		Query query = session.createQuery(qString);
		
		List<Student> list = query.list();
		
		for(Student s1 : list) {
			System.out.println(s1);
		}
		
		
		session.close();
		factory.close();		
//	=================== TYPE 3 ===============================
		
	}
	
}

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
		
		//creating objects of 2 questions & 2 answers
		Question q1 = new Question();
		Answer a1 = new Answer();
		Question q2 = new Question();
		Answer a2 = new Answer();
		
		
		//setting details of 1st Q & A
		q1.setId(651);
		q1.setQuestion("what is java ?");
		a1.setAnswerId(683);
		a1.setAnswer("java is programming language");
		a1.setQuestion(q1);
		q1.setAnswer(a1);		
		
		
		//setting details of 2nd Q & A
		q2.setId(648);
		q2.setQuestion("what is Android ?");
		a2.setAnswerId(616);
		a2.setAnswer("Android is linux based Opreating System");
		a2.setQuestion(q2);
		q2.setAnswer(a2);
		
		
		//steps to modify/insert data in database
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(q1);			
		session.save(a1);
		session.save(q2);
		session.save(a2);
		
		tx.commit();			//applying changes in database
		
		session.close();		
 		factory.close();	
	}	
}

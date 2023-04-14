package com.Git.gitHubHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
	
		Configuration cnf = new Configuration();
		cnf.configure("cofig.xml");
		SessionFactory factory = cnf.buildSessionFactory();
		
		//declaring object of Q & A
		Question q1 = new Question();
		Answer a1 = new Answer();
		Answer a2 = new Answer();
		Answer a3 = new Answer();
		
		//updating objects of Q & A
		q1.setId(6132);
		q1.setQuestion("what is java ? ");
		
		a1.setAnswerId(861);
		a1.setAnswer("java is object orianted programming language");
		a1.setQuestion(q1); 	//mapping answer with question
		
		a2.setAnswerId(186);
		a2.setAnswer("java is used to create softwares");
		a2.setQuestion(q1); 	//mapping answer with question
		
		a3.setAnswerId(953);
		a3.setAnswer("java have to collection of framework");
		a3.setQuestion(q1); 	//mapping answer with question
		
		
		
		//creating list to store questions
		List<Answer> list = new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		//mapping answer list to question
		q1.setList(list);
		
		
		
		//steps to modify/insert data in database
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(q1);
		session.save(a1);
		session.save(a2);
		session.save(a3);
		
		tx.commit();			//applying changes in database
		
		session.close();		
 		factory.close();	
 		System.out.println("done");
	}	
}

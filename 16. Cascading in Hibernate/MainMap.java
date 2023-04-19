package com.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainMap {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("configure.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Question q1 = new Question();
		Answer a1 = new Answer();
		Answer a2 = new Answer();
		Answer a3 = new Answer();
		
		//creating question
		q1.setQuestionId(455);
		q1.setQuestion("what is android?");
		
		//creating answers
		a1.setAnswerId(64);
		a1.setAnswer("android is linux based opreating system");
		a1.setQuestion(q1);
		
		a2.setAnswerId(644);
		a2.setAnswer("it is a software build for mobile");
		a2.setQuestion(q1);

		a3.setAnswerId(984);
		a3.setAnswer("software owned by Alphabet INC");
		a3.setQuestion(q1);
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		//mapping many answers to single question
		q1.setList(list);
		
		
		//preparing files to save on database
		Session session = factory.openSession();		//opening session 
		Transaction tx = session.beginTransaction(); 	//setting object 'tx' to further commit transaction in database 
		
		
		session.save(q1);		//question saved
		session.save(a1);		//saving answers
		session.save(a2);
		session.save(a3);
				
		tx.commit();			//changes saved to database

		session.close();	//good practice to always close an open object
		factory.close();	//good practice to always close an open object
	}
}

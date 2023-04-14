package com.Git.gitHubHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetching_Data {
	public static void main(String[] args) {
		Configuration cnf = new Configuration();
		cnf.configure("cofig.xml");
		SessionFactory factory = cnf.buildSessionFactory();
		
		
		Question question = new Question();
		Answer answer = new Answer();
		
		Session session = factory.openSession();
		
		//getting & printing question from database
		question = (Question)session.get(Question.class, 6132);
		System.out.println(question.getQuestion());
		
		
		//getting & printing answer from database
		for(Answer a: question.getList()) {
			System.out.println(a.getAnswer());
		}
		
	
		session.close();
		factory.close();
	}
}

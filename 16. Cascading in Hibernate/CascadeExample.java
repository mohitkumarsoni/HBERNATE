package com.Cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mapping.Answer;
import com.mapping.Question;

public class CascadeExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("configure.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Question q1 = new Question();
		q1.setQuestionId(54);
		q1.setQuestion("what is python ?");
		
		Answer a1 = new Answer(52,"python is used in machine learning",q1);
		Answer a2 = new Answer(44,"python is advanced programming language",q1);
		Answer a3 = new Answer(3748,"it is popular language",q1);
		
		List<Answer>list = new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setList(list);
		
		Transaction tx = session.beginTransaction();
		
		session.save(q1);
		
		tx.commit();
		session.close();
		factory.close();
	}
}

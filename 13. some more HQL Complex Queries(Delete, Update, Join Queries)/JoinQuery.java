package com.fetch;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class JoinQuery {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("configure.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		
//============= JOINING Question/ QuestionId(from Question class) & /Answer(from Answer class) Together ============================
		Query q = session.createQuery("select q.question, q.questionId, a.answer from Question as q INNER JOIN q.list as a");
				
		List <Object []> list = q.getResultList();
		for(Object []arr : list) {
			System.out.println(Arrays.toString(arr));
		}
		
		
		
		tx.commit();
		session.close();
		factory.close();
	}
	
}

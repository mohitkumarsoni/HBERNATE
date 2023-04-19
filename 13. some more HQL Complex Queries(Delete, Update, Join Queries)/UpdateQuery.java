package com.fetch;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateQuery {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("configure.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		//================ UPDATE QUERY =====================
		
		Query q = session.createQuery("update Student set duration=:d where course=:c");
		// duration=:d   & course=:c (here d & c are parameter which we will set or take from user)
		q.setParameter("d", "3 month");
		q.setParameter("c", "rust");
		
		int num = q.executeUpdate();
		System.out.println("number of fields updated : "+num);
		
		tx.commit();
		session.close();
		factory.close();
	}
}

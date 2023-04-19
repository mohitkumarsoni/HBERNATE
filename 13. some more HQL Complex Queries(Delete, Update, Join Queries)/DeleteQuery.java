package com.fetch;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteQuery {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("configure.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		//================ DELETE METHOD 1 (WITH QUERY) (most recommanded)=============================
		Query q = session.createQuery("delete from Student where course=:c");
		q.setParameter("c", "python");
		
		int num = q.executeUpdate();
		System.out.println("total num of deletations "+num);
		
		//==================== DELETE METHOD 2 (WITHOUT QUERY) ==========================
		System.out.println("===================================");
		Student s1 = (Student)session.get(Student.class, 1);
		session.delete(s1);
		
		tx.commit();
		session.close();
		factory.close();
	}
}

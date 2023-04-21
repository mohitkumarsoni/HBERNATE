package com.creteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.CRUD.SecondCache.Student;

public class CriteriaExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("config.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Criteria criteria = session.createCriteria(Student.class);
//		criteria.add(Restrictions.eq("name", "ravi"));			//show details of ravi
//		criteria.add(Restrictions.gt("id", 2));					//show details of id greater than 2
//		criteria.add(Restrictions.lt("id", 2));					//show details of id less than 2
		criteria.add(Restrictions.like("city", "m%"));			//filters & shows all city which starts from "m"
		
//=============== you can explore all filters in Restrictions class ================
		
		
		
		List<Student>list = criteria.list();
		
		for(Student s1 : list) {
			System.out.println(s1);
		}
		
		session.close();
		factory.close();
	}
}

/*
 * Criteria API is can be used in alternative to fetch data from database without writing HQL query.
 * Criteria is interface contains various static class, which you can use to filter data from database.
 */

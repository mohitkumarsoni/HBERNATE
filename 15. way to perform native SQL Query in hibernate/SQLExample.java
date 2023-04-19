package com.SQLQueries;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.fetch.Student;

public class SQLExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("configure.xml").buildSessionFactory();
		Session  session=factory.openSession();
		
		
		//this is sql query
		String query = "select * from Student";
		
		NativeQuery nq = session.createSQLQuery(query);
		
		List<Object[]> list = nq.list();
		
		for(Object []s1 : list) {
			System.out.println(s1[3]+":"+s1[1]);
		}
		
		
		session.close();
		factory.close();
	}
}

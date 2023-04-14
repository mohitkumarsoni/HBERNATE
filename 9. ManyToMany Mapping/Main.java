package com.Map;

//in this we will see how we can assign many projects to single employee & vice versa

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("conf.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Project p1 = new Project();
		Project p2 = new Project();
		
		e1.setEid(15);
		e1.setName("shyam");
		e2.setEid(65);
		e2.setName("gaurav");
		
		p1.setPid(85);
		p1.setpName("messaging app");
		p2.setPid(199);
		p2.setpName("chatBot");
		
		
		//storing details of projects & employees in list
		List<Employee> empList = new ArrayList<Employee>();
		List<Project> proList = new ArrayList<Project>();
		
		empList.add(e1);
		empList.add(e2);
		proList.add(p1);
		proList.add(p2);
		
		
		e1.setProjects(proList);		//first employee assigned 2 projects
		p1.setEmployees(empList);		//first project assigned 2 employees 
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);

		tx.commit();
		
		session.close();
		factory.close();
	}
}

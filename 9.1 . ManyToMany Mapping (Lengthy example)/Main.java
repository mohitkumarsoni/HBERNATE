package com.Many2Many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		Configuration cnf = new Configuration();
		cnf.configure("Hibernate.cfg.xml");
		SessionFactory factory = cnf.buildSessionFactory();
		
		
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Employee e3 = new Employee();
		
		Project p1 = new Project();
		Project p2 = new Project();
		Project p3 = new Project();
		Project p4 = new Project();
		
		//setting employee details		
		e1.setEid(10);
		e1.seteName("karan");
		
		e2.setEid(15);
		e2.seteName("abhishek");
		
		e3.setEid(20);
		e3.seteName("rohit");
		
	
		List<Employee> empListForFirstProject = new ArrayList<Employee>();
		List<Employee> empListForSecondProject = new ArrayList<Employee>();
		List<Employee> empListForThirdProject = new ArrayList<Employee>();
		List<Employee> empListForFourthProject = new ArrayList<Employee>();
		
		List<Project> proListForEmp1 = new ArrayList<Project>();
		List<Project> proListForEmp2 = new ArrayList<Project>();
		List<Project> proListForEmp3 = new ArrayList<Project>();
				
		//assigning employees on projects
		empListForFirstProject.add(e1);
		
		empListForSecondProject.add(e1);		
		
		empListForThirdProject.add(e1);

		empListForFourthProject.add(e1);
		empListForFourthProject.add(e2);
		empListForFourthProject.add(e3);
		
		//assigning projects to employees
		proListForEmp1.add(p1);
		proListForEmp1.add(p3);
		proListForEmp1.add(p4);
		
		proListForEmp2.add(p4);
		proListForEmp2.add(p2);
		
		proListForEmp3.add(p1);
		proListForEmp3.add(p4);
		
		
		//setting project details
		p1.setPid(50);
		p1.setpName("chat app");
		p1.setEmpList(empListForFirstProject);
		
		
		p2.setPid(55);
		p2.setpName("chatBot");
		p2.setEmpList(empListForSecondProject);
		
		p3.setPid(60);
		p3.setpName("e_commerce application");
		p3.setEmpList(empListForThirdProject);
		
		p4.setPid(65);
		p4.setpName("game development");
		p4.setEmpList(empListForFourthProject);
		
		//updating employee project list
		e1.setProList(proListForEmp1);
		e2.setProList(proListForEmp2);
		e3.setProList(proListForEmp3);
		
		//saving changes in database
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		session.save(e1);
		session.save(e2);
		session.save(e3);
		
		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.save(p4);	
	
		tx.commit();
		
		session.close();
		factory.close();
	}
}

package com.Git.gitHubHibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		Configuration cnf = new Configuration();
		cnf.configure("cofig.xml");
		SessionFactory factory = cnf.buildSessionFactory();
		
		
		System.out.println(factory);
		
	}
}

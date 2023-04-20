package cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.LifeCycle.Student;

public class SecondLevelCache {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("config.xml").buildSessionFactory();
		//first session
		Session session1 = factory.openSession();
		
		Student st1 = session1.get(Student.class, 10);
		System.out.println(st1.getName()+":"+st1.getId());
		
		session1.close();
		
		
		//second session
		Session session2 = factory.openSession();
		
		Student st2 = session2.get(Student.class, 10);
		System.out.println(st2.getName()+":"+st2.getId());
		
		
		session2.close();
		factory.close();
	}
}


/*	SECOND LEVEL CACHE IS BY DEFAULT TURNED OFF / LETS SEE HOW WE CAN TuRN IT ONN.
 * 
 *	to enable second level cache you need to add dependencies (Ehcache, Hibernate Ehcache Relocation ) in "pom.xml" file,
 *	also you have to configure your configuration, in our case (Kindly check our  "config.xml" file) 
 *	also to enable you have to mention it with annotation in your "Entity class" 
 *
 *
 *	in above example 2 sessions are fetching same data, with different sessions. in this case data is stored in second level cache 
 *	i.e : in SessionFactory, so query will pass single time, even if session is closed & opened multiple times
 *
 *	(type "EhcacheRegionFactory" in main method to copy import path, just to insert in "config.xml" file)

 
 */

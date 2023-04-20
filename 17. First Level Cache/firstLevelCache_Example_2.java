package cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.LifeCycle.Student;

public class firstLevelCache {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("cofig.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Student s1 = (Student)session.get(Student.class, 20);
		System.out.println(s1.getName()+":"+s1.getId());
		
		session.close();
		
		//==============================================
		Session session1 = factory.openSession();
		
		Student s2 = (Student)session1.get(Student.class, 20);
		System.out.println(s2.getName()+":"+s2.getId());
		
		session1.close();
		
		factory.close();
		
		/*
		 * first level cache is basically on the "Session" level, it will have objects in its memory which are used under "Session"
		 * unless session is not closed
		 * 
		 * in the above example there are 2 sessions fetching the same data, but because session & reopened again it will fire
		 * HQL query twice because as session is closed cache is cleared.
		 */
		
	}
}

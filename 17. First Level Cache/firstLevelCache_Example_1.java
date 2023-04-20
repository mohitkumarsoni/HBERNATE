package cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.LifeCycle.Student;

public class firstLevelCache_Example_1 {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("cofig.xml").buildSessionFactory();		
		Session session = factory.openSession();
		
		Student s1 = (Student)session.get(Student.class, 20);
		System.out.println(s1.getName()+":"+s1.getId());
		
		System.out.println("========== doing some task =================");
		
			
		Student s2 = (Student)session.get(Student.class, 20);
		System.out.println(s2.getName()+":"+s2.getId());
		
		
		session.close();
		factory.close();
		
		
		
		/*
		 * first level cache is basically on the "Session" level, it will have objects in its memory which are used under "Session"
		 * unless session is not closed
		 * 
		 *  in the above example session is fetched student data from database & stored in first object / than did some task/
		 * than requested for same object again,
		 * in this case HQL query won't be fired again, because data is already stored in session's cache memory.
		 * 
		 */
	}
}

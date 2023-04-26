package com.client;

import org.hibernate.Session;

import com.entity.Course;
import com.entity.Student;
import com.util.HibernateUtil;

public class ClientTest {
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSession();
		session.getTransaction().begin();
		
		Course c1=new Course();
		c1.setCourseName("genetics");
		c1.setCourseFee(31000.00);
		
		
		Student s1=new Student();
		s1.setfName("poojitha");;
		s1.setlName("mamidi");
		s1.setEmail("poojitha@gmail.com");
		s1.setCourse(c1);
		c1.setStudent(s1);
		
		session.persist(s1);
		
		
		
		
		session.getTransaction().commit();
		HibernateUtil.closeSession(session);
		
	}

}

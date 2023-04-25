package com.clientTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Student;

public class StudentClientTest {
	
	public static void main(String[] args) {
		
		Configuration configuration=new Configuration().configure("studentconfig.xml");
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		
		
		
		Student s1=new Student("poojitha", 25000.00);
		Student s2=new Student("kranthi", 25000.00);
		Student s3=new Student("raji", 25000.00);
		Student s4=new Student("afreen", 25000.00);
		Student s5=new Student("yamini", 25000.00);
		Student s6=new Student("vamsi", 25000.00);
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		session.save(s5);
		session.save(s6);

		session.getTransaction().commit();
		session.close();

	}

}

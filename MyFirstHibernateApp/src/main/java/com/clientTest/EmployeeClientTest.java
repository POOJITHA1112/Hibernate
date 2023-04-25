package com.clientTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Employee;

public class EmployeeClientTest {
	
	public static void main(String[] args) {
		 
		
		Configuration configuration=new Configuration().configure("hibernate.config.xml");
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		
		Employee e1=new Employee("poojitha", 30000.00, "poojitha@gmail.com");
		Employee e2=new Employee("ukku", 40000.00, "ukku@gmail.com");
		Employee e3=new Employee("kranthi", 34000.00, "kranthi@gmail.com");
		Employee e4=new Employee("swaroopa", 50000.00, "swaroopa@gmail.com");
		Employee e5=new Employee("sadanandam", 60000.00, "sadanandam@gmail.com");
		Employee e6=new Employee("rummy", 34000.00, "rummy@gmail.com");
		
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);
		session.save(e5);
		session.save(e6);

		session.getTransaction().commit();
		session.close();
		
	}

}

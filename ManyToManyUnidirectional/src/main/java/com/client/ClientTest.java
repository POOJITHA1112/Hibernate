package com.client;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Car;
import com.entity.Person;
import com.util.HibernateUtil;

public class ClientTest {
	
	
		public static void insert() {
		
		Configuration conf=new Configuration().configure("manytomanyunidirection.config.xml");
		SessionFactory sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		
		Person p1=new Person();
		p1.setfName("Chiru");
		p1.setlName("K");
		p1.setEmail("chiru@gmail.com");
		
		Person p2=new Person();
		p2.setfName("RamCharan");
		p2.setlName("K");
		p2.setEmail("ramcharan@gmail.com");
		
		Person p3=new Person();
		p3.setfName("AlluArjun");
		p3.setlName("A");
		p3.setEmail("alluarjun@gmail.com");
		
		Car c1=new Car();
		c1.setBrand("Maruthi");
		c1.setColor("Red");
		c1.setPrice(700000.00);
		
		Car c2=new Car();
		c2.setBrand("RollsRoyce");
		c2.setColor("Black");
		c2.setPrice(250000000.00);
		
		Car c3=new Car();
		c3.setBrand("BMW");
		c3.setColor("Blue");
		c3.setPrice(20000000.00);
		
		List<Car>cars=new ArrayList<Car>();
		cars.add(c1);
		cars.add(c2);
		cars.add(c3);
		p1.setCars(cars);
		p2.setCars(cars);
		p3.setCars(cars);
		
		session.persist(p1);
		session.persist(p2);
		session.persist(p3);
		
		session.getTransaction().commit();
		session.close();
		
	}
		
		public static void main(String[] args) {
//			insert();
			
			
			Configuration conf=new Configuration().configure("manytomanyunidirection.config.xml");
			SessionFactory sessionFactory = conf.buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			Person person = session.get(Person.class, 2l);
			System.out.println(person.getId());
			System.out.println(person.getfName());
			System.out.println(person.getlName());
			System.out.println(person.getEmail());
			
			
			
			
//			System.out.println(person.getCars());
			
			
			
			session.getTransaction().commit();
			session.close();
			
		}

}

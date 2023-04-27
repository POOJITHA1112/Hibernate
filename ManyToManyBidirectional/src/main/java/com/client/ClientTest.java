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

		Configuration conf = new Configuration().configure("manytomanybidirection.config.xml");
		SessionFactory sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();

		Person p1 = new Person();
		p1.setfName("Chiru");
		p1.setlName("K");
		p1.setEmail("chiru@gmail.com");

		Person p2 = new Person();
		p2.setfName("RamCharan");
		p2.setlName("K");
		p2.setEmail("ramcharan@gmail.com");

		Person p3 = new Person();
		p3.setfName("AlluArjun");
		p3.setlName("A");
		p3.setEmail("alluarjun@gmail.com");

		Car c1 = new Car();
		c1.setBrand("Maruthi");
		c1.setColor("Red");
		c1.setPrice(700000.00);

		Car c2 = new Car();
		c2.setBrand("RollsRoyce");
		c2.setColor("Black");
		c2.setPrice(250000000.00);

		Car c3 = new Car();
		c3.setBrand("BMW");
		c3.setColor("Blue");
		c3.setPrice(20000000.00);

		List<Car> cars = new ArrayList<Car>();
		cars.add(c1);
		cars.add(c2);
		cars.add(c3);
		p1.setCars(cars);
		p2.setCars(cars);
		p3.setCars(cars);

		List<Person> p = new ArrayList<Person>();
		p.add(p1);
		p.add(p2);
		p.add(p3);

		c1.setPersons(p);
		c2.setPersons(p);
		c3.setPersons(p);
//
//		session.persist(p1);
//		session.persist(p2);
//		session.persist(p3);

		session.getTransaction().commit();
		session.persist(p1);

		session.close();
//		session.save(p1);


	}

	public static void main(String[] args) {
		insert();

	}

}

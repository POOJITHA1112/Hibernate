 package com.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.entity.Person;

public class ClientTest {

	public static void main(String[] args) throws ParseException {

		Configuration configuration = new Configuration().configure("person.config.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();

		String dob1 = "2002/05/02";
		String dob2 = "1997/04/29";
		String dob3 = "2002/07/23";
		String dob4 = "1997/07/27";
		String dob5 = "2000/05/25";
		String dob6 = "1995/07/17";

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date d1 = dateFormat.parse(dob1);
		Date d2 = dateFormat.parse(dob2);
		Date d3 = dateFormat.parse(dob3);
		Date d4 = dateFormat.parse(dob4);
		Date d5 = dateFormat.parse(dob5);
		Date d6=dateFormat.parse(dob6);

//		Person p1=new Person("Poojitha", "M", "poojitha@gmail.com", d1,30000.00);
//		Person p2=new Person("Yamini", "B", "yamini@gmail.com", d2,28000.00);
//		Person p3=new Person("Raji", "B", "rajasri@gmail.com", d3,32000.00);
//		Person p4=new Person("Afreen", "fathima", "afreen@gmail.com", d4,53000.00);
		Person p5 = new Person("Harish", "s", "harish@gmail.com", d5,42000.00);


//		session.persist(p1);
//		session.persist(p2);
//		session.persist(p3);
//		session.persist(p4);
//		session.persist(p5);

		
		session.getTransaction().commit();


		Person p1 = session.get(Person.class, 1l);
		System.out.println(p1);
//		Person p2 = session.get(Person.class, 2l);
//		System.out.println(p2);
//
//		System.out.println("-------Start hql------");
//		Query query = session.createQuery("from Person");
//
//		List list = query.list();
//		for (Object object : list) {
//			System.out.println(object);
//
//		}
//
//		System.out.println("------------navtive sql-------------");
//		NativeQuery query2 = session.createNativeQuery("select * from persons");
//		List<Object[]> list2 = query2.list();
//		for (Object[] object : list2) {
//			System.out.println(object[0]);
//			System.out.println(object[1]);
//			System.out.println(object[2]);
//			System.out.println(object[3]);
//			System.out.println(object[4]);

//		}
		session.close();

	}

}

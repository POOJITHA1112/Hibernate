package com.client;

import java.util.Date;

import org.hibernate.Session;

import com.entity.Person;
import com.util.HibernateUtil;

public class PersistantObjectLifeCycle {
	
	public static void main(String[] args) {
//		sessionSave();
		sessionMerge();

	}

	
	public static void sessionSave() {
		System.out.println("1----------------------sesssion starting here");
		Session session=HibernateUtil.getSession();
		session.getTransaction().begin();
		System.out.println("2---------------------begin");
		Person p1=new Person("rammy", "mamidi", "remeshhh@gmail.com", new Date(),40000.00);
		System.out.println("3---------------------------");
		System.out.println(p1);
		session.persist(p1);
		p1.setFirstName("sadanandam");
		System.out.println("4----------------------------");
		session.getTransaction().commit();
		System.out.println("5-----------------------------");
		HibernateUtil.closeSession(session);
		System.out.println("6------------------------------");
		
		
	}
	
	public static void sessionMerge() {
		System.out.println("1----------------------sesssion starting here");
		Session session=HibernateUtil.getSession();
		session.getTransaction().begin();
		System.out.println("2---------------------begin");
		Person p2=(Person)session.get(Person.class, 12l);
		System.out.println("3------------------------");
		System.out.println(p2);
		session.detach(p2);
		System.out.println("4--------------------------");
		p2.setSalary(32000.00);
		session.merge(p2);
		Person p3=(Person)session.get(Person.class, 2l);
		System.out.println("5--------------------------");
		System.out.println(p3);
		session.close();
		System.out.println("6---------------------------");

	}
	
}

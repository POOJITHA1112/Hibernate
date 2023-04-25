package com.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connection {
	
	public static  SessionFactory sessionFactory;
	
	static {
		
		Configuration configuration=new Configuration().configure("crud.config.xml");
		sessionFactory= configuration.buildSessionFactory();
		System.out.println(sessionFactory);
		
	}
	
	public static  Session getSession() {
		return sessionFactory.openSession();
	}
	
	public static void closeSession(Session session) {
		if(session!=null) {
			session.close();
		}
	}
	
	public static void main(String[] args) {
		
	}

}

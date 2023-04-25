package com.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnection {
	
	 private static SessionFactory sf;
	
	static {
		Configuration cf=new Configuration().configure("manytoone.config.xml");
		sf=cf.buildSessionFactory();
		System.out.println(sf);
	}
	public static Session getSession() {
		return sf.openSession();
	}
	public static void closeSession(Session session) {
		if(session!=null) 
//			session.close();
//		}
		session.close();
	}
	public static void main(String[] args) {
		System.out.println(getSession());

		
	}

}

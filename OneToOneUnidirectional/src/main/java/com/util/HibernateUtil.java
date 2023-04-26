package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	static SessionFactory sf;
	
	static {
	
	Configuration conf=new Configuration().configure("onetomanybirection.config.xml");
	sf=conf.buildSessionFactory();
	System.out.println(sf);

	}
	
	public static  Session getSession() {
		return sf.openSession();
	
	}
	
	public static void closeSession(Session session) {
		if(session!=null) {
		}
		session.close();

	}
	public static void main(String[] args) {
		
		getSession();
		
	}
			
}

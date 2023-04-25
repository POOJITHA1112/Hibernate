package com.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Address;
import com.entity.Name;
import com.entity.User;

public class UserTest {
	
	public static void main(String[] args) {
		
		
		Configuration conf=new Configuration().configure("mismatch.config.xml");
		SessionFactory sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Address ad1=new Address("Hyd", "Telanga");
		Name n1=new Name("Poojitha","Mamidi");
		User u1=new User(1, n1, ad1);
		session.merge(u1);
//		transaction.commit();
		session.getTransaction().commit();
		session.close();
		
	}

}

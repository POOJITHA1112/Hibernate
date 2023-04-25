package com.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;
import com.entity.LeaveTracker;
import com.util.HibernateConnection;

public class ClientTest {
	
	public static void main(String[] args) {
		
		Configuration cf=new Configuration().configure("mismatch.config.xml");
		SessionFactory sessionFactory = cf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		
//		 Session session=HibernateConnection.getSession();
//		 session.getTransaction().begin();
		 LeaveTracker lt=new LeaveTracker(3, 4, 120, 5);
		 Employee e1=new Employee("poojitha", 30000.00, lt);
		 session.persist(e1);
		 LeaveTracker lt2=new LeaveTracker(4, 5, 120, 4);
		 Employee e2=new Employee("kranthi", 32000.00, lt2);
		 session.persist(e2);


		 session.getTransaction().commit();
		 if(transaction!=null) {
			 transaction.rollback();
		 }
//		 HibernateConnection.closeSession(session);
		 session.close();
	}

}

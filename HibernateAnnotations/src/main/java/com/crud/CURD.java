package com.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.util.HibernateUtil;

public class CURD {

	public static void main(String[] args) {
//		create();
//		retrieve();
//		update(45l);
//		delete(58l);
		pagination();
	
	}

	public static void create() {
		Session session = Connection.getSession();
		Transaction transaction = session.beginTransaction();
		Poojitha p1 = new Poojitha("poojitha", "poojitha@gmail.com", 30000.00);
		Poojitha p2 = new Poojitha("kranthi", "kranthi@gmail.com", 30000.00);
		Poojitha p3 = new Poojitha("raji", "raji@gmail.com", 30000.00);
		Poojitha p4 = new Poojitha("yamini", "yamini@gmail.com", 30000.00);
		Poojitha p5 = new Poojitha("affu", "affu@gmail.com", 30000.00);
		Poojitha p6 = new Poojitha("harish", "harish@gmail.com", 30000.00);
		Poojitha p7 = new Poojitha("bhargav", "bhargav@gmail.com", 30000.00);

//		session.persist(p1);
//		session.persist(p2);
//		session.persist(p3);
//		session.persist(p4);
//		session.persist(p5);
//		session.persist(p6);
//		session.persist(p7);

		transaction.commit();
		transaction.rollback();
		session.close();
	}
	public static void retrieve() {

		Session session = Connection.getSession();
		Transaction transaction = session.getTransaction();
//		transaction.begin();
//		Poojitha p = session.get(Poojitha.class,2l);
		Poojitha p1 = session.load(Poojitha.class, 2l);
//		System.out.println(p);
		System.out.println(p1);
		transaction.rollback();
 		session.close();
	}
	
	public static void delete() {
		Session session=Connection.getSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		Poojitha p3=session.get(Poojitha.class, 3l);
		session.delete(p3);
		transaction.commit();
		session.close();
}	
	
	
	
	
	public static void update() {
		Session session=Connection.getSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		Poojitha p = session.get(Poojitha.class, 10l);
		p.setName("swaroopa");
		session.save(p); 
		transaction.commit();
		session.close();
		
	}
//	public static void update(long id) {
//		Session session=Connection.getSession();
//		Transaction transaction=session.getTransaction();
//		transaction.begin();
//		 Query query=session.createQuery("update Poojitha p set p.name=:name where p.id=:id");
//		query.setParameter("name", "vamshi");
//		query.setLong("id", id);
//		int result = query.executeUpdate();
//		System.out.println(result);
//		transaction.commit();
//		transaction.rollback();
//		session.close();
//	}
//	public static void delete(long pid) {
//		Session session=Connection.getSession();
//		Transaction transaction = session.getTransaction();
//		transaction.begin();
//		Query query = session.createQuery("delete from Poojitha p where p.id=:id");
//		query.setParameter("id",pid);
//		int result=query.executeUpdate();
//		System.out.println(result);
//		transaction.commit();
//		transaction.rollback();
//
//		session.close();
//	}	
	public static void pagination() {
		
		Session session=HibernateUtil.getSession();
		Query query = session.createQuery("from Poojitha");
		int pagenumber=1;
		int pageSize=10;
		query.setFirstResult(pagenumber-1);
//		query.setFirstResult(0);
		query.setMaxResults(pageSize);
		pagenumber+=pageSize;
		List list = query.getResultList();
		list.forEach(System.out::println);
	}
	}
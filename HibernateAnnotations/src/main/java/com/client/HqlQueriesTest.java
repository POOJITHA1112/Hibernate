package com.client;

import java.util.List;
import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.crud.Poojitha;
import com.entity.Person;
import com.util.HibernateUtil;

public class HqlQueriesTest {
	public static void main(String[] args) {
//		getAll();
//		getAllWithPositions();
//		getById();
//		getByIdWIthBug(3l);
//		getAllOrderBy();
//		pagination();
//		count();
		delete();
		
	}
	
	public static void getAll() {
		Session session=HibernateUtil.getSession();
		String getAll="from Person";
		Query query = session.createQuery(getAll);
		List<Person> list = query.list();
		list.forEach(System.out::println);
	}
	public static void getAllWithPositions() {
		
		Session session=HibernateUtil.getSession();
		String getAllPositions="select p.firstName,p.lastName,date from Person p";
		Query query = session.createQuery(getAllPositions);
		List<Object[]> list = query.list();
		for(Object[] obj:list) {
			System.out.println(obj[0]);
			System.out.println(obj[1]);
			System.out.println(obj[2]);
			
		}
		
	}
	
	public static void getById() {
		Session session=HibernateUtil.getSession();
		String getByid="select p.firstName,p.lastName from Person p where p.id=1";
		Query query = session.createQuery(getByid);
		List<Object[]> list = query.list();
		for (Object[] obj : list) {
			System.out.println(obj[0]);
			System.out.println(obj[1]);
			
		}
		
	}
	
	public static void getByIdWIthBug(long pid) {
		Session session=HibernateUtil.getSession();
		String getByid="select p.firstName,p.lastName from Person p where p.id=:id";
		Query query = session.createQuery(getByid).setLong("id", pid);
		List<Object[]> list = query.list();
		for(Object[]obj:list) {
			System.out.println(obj[0]);
			System.out.println(obj[1]);
		}

	}
	
	public static void getAllOrderBy() {
		Session session=HibernateUtil.getSession();
		session.getTransaction().begin();
		String getAll="from Person p order by p.lastName desc ";
		Query query = session.createQuery(getAll);
		List<Person> list = query.list();
		list.forEach(System.out::println);
	}
	
	public static void groupBy() {
		Session session=HibernateUtil.getSession();
			String groupBy="from Person p order by p.lastName desc ";
			Query query = session.createQuery(groupBy);
			List<Person> list = query.list();
			list.forEach(System.out::println);
		}
	String hql = "SELECT SUM(E.salary), E.firtName FROM Employee E " +
            "GROUP BY E.firstName";
		
		public static void pagination() {
			
			Session session=HibernateUtil.getSession();
			Query query = session.createQuery("from Person");
			int pagenumber=1;
			int pageSize=10;
//			query.setFirstResult(pagenumber-1);
			query.setFirstResult(0);
			query.setMaxResults(pageSize);
//			pagenumber+=pageSize;
			List list = query.getResultList();
			list.forEach(System.out::println);
		}
		
		public static void count() {
			Session session=HibernateUtil.getSession();
			 Query query =session.createQuery("select count(email) from Person ");
//			 query.ad
		}
		
		
		public static void delete() {
			Session session=HibernateUtil.getSession();
			Transaction transaction = session.getTransaction();
			transaction.begin();
			Person p=session.get(Person.class, 10l);
			session.delete(p);
			transaction.commit();
			session.close();
		
		}
	

}

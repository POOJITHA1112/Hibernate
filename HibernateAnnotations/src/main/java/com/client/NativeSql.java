package com.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.StandardBasicTypes;

import com.util.HibernateUtil;

public class NativeSql {
	
	public static void main(String[] args) {
//		getAllPersons();
//		getAllwithPositions();
//		getAllWithParameterBinding();
//		getAggregateFunction();
//		maxValue();
//		minSalary();
//		avgSalary();
		sumSalary();
		
	}
	
	@SuppressWarnings("deprecation")
	public static void getAllPersons() {
		org.hibernate.Session session=HibernateUtil.getSession();
		Query query=session.createNativeQuery("select * from persons");
		session.beginTransaction().commit();
		List<Object[]> list = query.list();
		for(Object[]obj:list) {
			System.out.println(obj[0]);
			System.out.println(obj[1]);
			System.out.println(obj[2]);
			System.out.println(obj[3]);
			System.out.println(obj[4]);

		}
		
	}
	
	public static void getAllwithPositions() {
		Session session=HibernateUtil.getSession();
		Query query=session.createSQLQuery("select person_id as id,firstName as Name,Email from persons");
		List<Object[]>list=query.list();
		for(Object[]obj:list) {
			System.out.println(obj[0]);
			System.out.println(obj[1]);
			System.out.println(obj[2]);
		}
		
	}
	
	
	
	@SuppressWarnings("deprecation")
	public static void getAllWithParameterBinding() {
		Session session=HibernateUtil.getSession();
		 SQLQuery query=session.createSQLQuery("select * from persons");
		 query.addScalar("person_id",StandardBasicTypes.LONG);
		 query.addScalar("firstName", StandardBasicTypes.STRING);
		 query.addScalar("lastName", StandardBasicTypes.STRING);
		 query.addScalar("Email", StandardBasicTypes.STRING);
		 query.addScalar("date", StandardBasicTypes.DATE);
		 List<Object[]> list = query.list();
		 for(Object[]obj:list) {
			 System.out.println(obj[0]);
			 System.out.println(obj[1]);
			 System.out.println(obj[2]);
			 System.out.println(obj[3]);
			 System.out.println(obj[4]);

		 }
	}
	
	@SuppressWarnings("deprecation")
	public static void getAggregateFunction() {
		Session session=HibernateUtil.getSession();
		 SQLQuery query= session.createSQLQuery("select count(email)as maxEmail from persons");
		query.addScalar("maxEmail",StandardBasicTypes.LONG);
		Object result = query.uniqueResult();
		System.out.println(result);
	}
	
	
	public static void maxValue() {
		Session session=HibernateUtil.getSession();
		SQLQuery query=session.createSQLQuery("select max(salary)as MaxSalary from persons");
		query.addScalar("MaxSalary",StandardBasicTypes.LONG);
		 Object result=query.uniqueResult();
		 System.out.println(result);

	}
	
//	@SuppressWarnings("deprecation")
//	public static void minSalary() {
//		Session session=HibernateUtil.getSession();
//		 SQLQuery query=session.createSQLQuery("select firstName,min(salary) as MinSalary  from persons  group by firstname");
//		 query.addScalar("MinSalary",StandardBasicTypes.LONG);
//		 Object result = query.uniqueResult();
//		 System.out.println(result);
//		
//	}
	
	public static void avgSalary() {
		Session session=HibernateUtil.getSession();
		 SQLQuery query=session.createSQLQuery("select avg(salary)as AverageSalary from persons");
		 query.addScalar("AverageSalary", StandardBasicTypes.LONG);
		Object result= query.uniqueResult();
		System.out.println(result);
		
	}
	
	public static void sumSalary() {
		Session session=HibernateUtil.getSession();
		 SQLQuery query=session.createSQLQuery("select sum(salary)as SumofSalaries from persons");
//		 query.addScalar("SumofSalaries",StandardBasicTypes.LONG);
		 query.addScalar("SumofSalaries");
		  Object result=query.uniqueResult();
		  System.out.println(result);
		
	}
	
}

package com.client;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import com.entity.Person;
import com.util.HibernateUtil;

public class CriteriaApi {

	public static void main(String[] args) {
//		getAll();
//		getSpecifiedColumns() ;
//		getById(2l);
//		getEmails();
//		//dobCondition();
//		salaryList();
//		like();
//		sum();
//		minSalary();
//		maxSalary();
//		avgSalary();
//		CountFirstName();
		isNull();

	}

	@SuppressWarnings("deprecation")
	public static void getAll() {
		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(Person.class);
		List list = criteria.list();
//		System.out.println(list);
		for (Object object : list) {
			System.out.println(object);
		}
	}

	// select firstName,lastName,date from persons
	public static void getSpecifiedColumns() {
		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(Person.class);
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("firstName"));
		projectionList.add(Projections.property("lastName"));
		projectionList.add(Projections.property("email"));
		criteria.setProjection(projectionList);
		List<Object[]> list = criteria.list();
		for (Object[] obj : list) {
			System.out.println(obj[0]);
			System.out.println(obj[1]);
			System.out.println(obj[2]);
			System.out.println("----------");
		}

	}

	// select * from persons where id=?
	@SuppressWarnings("deprecation")
	public static void getById(long pid) {
		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(Person.class);
		Criterion eq = Restrictions.eq("id", pid);
		criteria.add(eq);
		Object result = criteria.uniqueResult();
		System.out.println(result);

	}

	// select email from persons
	public static void getEmails() {
		Session session = HibernateUtil.getSession();
		Criteria cr = session.createCriteria(Person.class);
		cr.setProjection(Projections.property("email"));
//		 List<Object> list = cr.list();
//		 for (Object object : list) {
//			 System.out.println(object);
//			
//		}
		List<String> list = cr.list();
		for (String sr : list) {
			System.out.println(sr);
		}

	}

//	public static void dobCondition() {
//		Session session = HibernateUtil.getSession();
//		Criteria criteria = session.createCriteria(Person.class);
//		criteria.add(Restrictions.gt("date", 1997));
//		//Criterion gt = Restrictions.gt("date", 2000 - 01 - 01);
//		//criteria.add(gt);
//		List<Person> list = criteria.list();
//		for (Person object : list) {
//			System.out.println(object);
//
//		}
//
//	}
	
	
	public static void salaryList() {
		Session session=HibernateUtil.getSession();
		 Criteria cr=session.createCriteria(Person.class);
		 cr.add(Restrictions.gt("salary",23000.00));
		 List<Person> list = cr.list();
		 for (Person person : list) {
			System.out.println(person);
		}
		
	}
	
	public static void like() {
		Session session=HibernateUtil.getSession();
		 Criteria cr=session.createCriteria(Person.class);
		 cr.add(Restrictions.like("firstName", "%ji%"));
		 List<Person> list = cr.list();
		 for (Person person : list) {
			System.out.println(person);
		}
		
	}
	
	public static void sum() {
		Session session = HibernateUtil.getSession();
		 Criteria cr=session.createCriteria(Person.class);
		 cr.setProjection(Projections.sum("salary"));
		 Object result = cr.uniqueResult();
		 System.out.println(result);
			
		}
	
	public static void minSalary() {
		Session session = HibernateUtil.getSession();
		 Criteria cr=session.createCriteria(Person.class);
		 cr.setProjection(Projections.min("salary"));
		 Object result = cr.uniqueResult();
		 System.out.println(result);
		
	}
		
	public static void maxSalary() {
		Session session = HibernateUtil.getSession();
		 Criteria cr=session.createCriteria(Person.class);
		   cr.setProjection(Projections.max("salary"));
		   Object result = cr.uniqueResult();
		   System.out.println(result);
		 
	}
	
	public static void avgSalary() {
		Session session = HibernateUtil.getSession();
		 Criteria cr=session.createCriteria(Person.class);
		 cr.setProjection(Projections.avg("salary"));
		 Object result = cr.uniqueResult();
		 System.out.println(result);
		 
	}
	
	public static void CountFirstName() {
		Session session = HibernateUtil.getSession();
		 Criteria cr=session.createCriteria(Person.class);
		 cr.setProjection(Projections.count("firstName"));
		 List list = cr.list();
		 for (Object object : list) {
			 System.out.println(object);
			
		}
		
	}
	
	public static void isNull() {
		Session session = HibernateUtil.getSession();
		 Criteria cr=session.createCriteria(Person.class);
		 cr.add(Restrictions.isNull("salary"));
		 List<Person> list = cr.list();
		 for (Object object : list) {
			System.out.println(object);
		}
		
	}
		
	}
	
	


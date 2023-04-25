package com.client;

import java.util.List;


import javax.persistence.NamedQuery;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.entity.Person;
import com.util.HibernateUtil;

public class NamedQueries {
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSession();
//		List<Person> persons = session.createNamedQuery("person.findAll").list();
//		persons.forEach(System.out::println);
		
		List<Object[]> list = session.createNamedQuery("person.getSpecificColumns").list();
		for (Object[] obj : list) {
			System.out.println(obj[0]);
			System.out.println(obj[1]);
			System.out.println(obj[2]);
			
		}
		
		 List<Object[]> list2 = session.createNamedQuery("getById").list();
		for (Object[] object : list2) {
			System.out.println(object[0]);
			System.out.println(object[1]);

			
			
		}
		}
	}
	
	
	
	

   

package com.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


import com.entity.Customer;
import com.util.CustomerUtil;
import com.util.HibernateUtil;

public class CustomerHqlQueryTest {
	
	public static void main(String[] args) {
//		getAll();
//		getAllWithPosition();
//		getById();
//		getByIdWithdebug(4);
		getAllOrderBy();
		
		
	}
	
	
	public static void getAll() {
		Session session=CustomerUtil.getSession();
		Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();
		list.forEach(System.out::println);
		
	}
	
	@SuppressWarnings("deprecation")
	public static void getAllWithPosition() {
		Session session=CustomerUtil.getSession();
		Query query=session.createQuery("select c.firstName,c.email,c.date from Customer c");
		List<Object[]>list=query.list();
		for (Object[] obj : list) {
			System.out.println(obj[0]);
			System.out.println(obj[1]);
			System.out.println(obj[2]);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void getById() {
		Session session=CustomerUtil.getSession();
	    Query query = session.createQuery("select c.firstName,c.lastName,c.email from Customer c where id=2l");
		List<Object[]> list = query.list();
		for(Object[]obj:list) {
			System.out.println(obj[0]);
			System.out.println(obj[1]);
			System.out.println(obj[2]);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void getByIdWithdebug(int id) {
		Session session=CustomerUtil.getSession();
		 Query query=session.createQuery("select c.firstName,c.lastName,c.email from Customer c where id=:cid").setInteger("cid", id);
		 List<Object[]> list = query.list();
		for(Object[]obj:list) {
			System.out.println(obj[0]);
			System.out.println(obj[1]);
			System.out.println(obj[2]);
		}
		 
	}
	
	public static void getAllOrderBy() {
		Session session=CustomerUtil.getSession();
		Query query = session.createQuery("from Customer c order by c.firstName desc");
		List<Customer> list = query.list();
		list.forEach(System.out::println);
		
	}
	

}

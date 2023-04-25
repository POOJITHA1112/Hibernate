package com.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Customer;

public class CustomerClient {
	
	public static void main(String[] args) throws ParseException {
		
		Configuration configuration=new Configuration().configure("customer.config.xml");
		 SessionFactory sessionFactory=configuration.buildSessionFactory();
		  Session session=sessionFactory.openSession();
		  session.getTransaction().begin();
		  
		  
		  String dop1="2022/04/15";
		  SimpleDateFormat df1=new SimpleDateFormat("yyyy/MM/dd");
		  Date d1=df1.parse(dop1);
		  
		  
		  String dop2="2023/01/23";
		  SimpleDateFormat df2=new SimpleDateFormat("yy/MM/dd");
		  Date d2=df2.parse(dop2);
		   
		  
		  Customer c1=new Customer("poojitha", "mamidi", "poojitha@gmail.com", d1);
		  Customer c2=new Customer("raji", "bandari", "raji@gmail.com", new Date());
		  Customer c3=new Customer("yamini", "yamu", "yamini@gmail.com", new Date());
		  Customer c4=new Customer("harishhhhhh", "harishuuuuuu", "harsih@gmail.com", d2);
		  Customer c5=new Customer("afreen", "affu", "affu@gmail.com", new Date());
		  
		
		  session.persist(c1);
		  session.persist(c2);
		  session.persist(c3);
		  session.persist(c4);
		  session.persist(c5);
		  session.getTransaction().commit();
		  session.close();
	
	}

}

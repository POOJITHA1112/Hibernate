package com.client;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import com.entity.Address;
import com.entity.Person;
import com.util.HibernateConnection;

public class ClientTest {
	
	public static void main(String[] args) {
		
		  Session  session=HibernateConnection.getSession();
		  session.getTransaction().begin();
//		  Person p=new Person("Poojitha", "Mamidi");
//		  Address ad=new Address("hyd", "TS", p);
//		  
//		  
//		  session.save(ad);
//		  session.save(p);
		  
		 Criteria cr= session.createCriteria(Person.class);
		 Criterion cn = Restrictions.eq("city", "hyd");
		 cr.add(cn);
		 Address result = (Address) cr.uniqueResult();
		 System.out.println(result.getPerson().getFname());
		 
		  
		  
		  session.getTransaction().commit();
		  session.close();
	}

}

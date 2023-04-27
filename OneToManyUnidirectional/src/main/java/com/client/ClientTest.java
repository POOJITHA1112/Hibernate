package com.client;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.entity.Customer;
import com.entity.Products;
import com.util.HibernateConnection;

public class ClientTest {
	public static void main(String[] args) {
		
		 Session session=HibernateConnection.getSession();
		 session.getTransaction().begin();
		 Products Tv=new Products("OnidaTv", 40000.00);
		 Products mbl=new Products("Infinix", 15000.00);
		 Products watch=new Products("FastTrack", 2000.00);
		 
		 List<Products>products=new ArrayList<Products>();
		 products.add(Tv);
		 products.add(mbl);
		 products.add(watch);
		 
		 Customer Rohith=new Customer( "Rohith", "Sharma", 7000.00, products);
		 session.save(Rohith);
		 session.save(Tv);
		 session.save(mbl);
		 session.save(watch);
		 
		 session.getTransaction().commit();
		 HibernateConnection.closeSession(session);
		 
		 
		
		
	}
	
	
}

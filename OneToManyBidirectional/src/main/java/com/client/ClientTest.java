package com.client;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;

import com.entity.Address;
import com.entity.Employee;
import com.mysql.cj.util.Util;
import com.util.HibernateUtil;

public class ClientTest {
		
	public static void Insert() {
	
		Session session = HibernateUtil.getSession();
		session.getTransaction().begin();
		
		Address currentAddress=new Address();
		currentAddress.setCity("Hyd");
		currentAddress.setState("TS");
		currentAddress.setZipCode(500038);
		
		Address permanentAddress=new Address();
		permanentAddress.setCity("Mncl");
		permanentAddress.setState("Krntka");
		permanentAddress.setZipCode(504303);
		
		List<Address>address=new ArrayList<Address>();
		address.add(permanentAddress);
		address.add(currentAddress);
		
		Employee e=new Employee();
		e.setfName("poojitha");
		e.setlName("mamidi");
		e.setEmail("pooja@gmail.com");
		e.setMblNmbr(123456l);
		e.setAddress(address);
		e.setSalary(30000.00);
		currentAddress.setEmployee(e);
		permanentAddress.setEmployee(e);
		
		session.persist(e);
//		session.delete(e);
//		session.persist(permanentAddress);
//		session.persist(currentAddress);
		session.getTransaction().commit();
		HibernateUtil.closeSession(session);
	}
	
	public static void main(String[] args) {
//		Insert();
		
		Session session = HibernateUtil.getSession();
		session.getTransaction().begin();
		Employee employee = session.get(Employee.class, 1);
//		System.out.println(employee.getId());
//		System.out.println(employee.getfName());
//		System.out.println(employee.getlName());
//		System.out.println(employee.getEmail());
//		System.out.println(employee.getMblNmbr());
//		System.out.println(employee.getSalary());
		List<Address> list = employee.getAddress();
		for (Address address : list) {
			System.out.println(address.getAid());
			System.out.println(address.getCity());
			System.out.println(address.getState());
			System.out.println(address.getZipCode());
		}
		
		
		session.getTransaction().commit();
		HibernateUtil.closeSession(session);
	}

}

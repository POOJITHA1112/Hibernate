package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	private String city;
	private String state;
	private long ZipCode;
	
	@ManyToOne
	private Employee employee;
	
	
	public Address() {
		// TODO Auto-generated constructor stub
	}


	public Address(String city, String state, long zipCode, Employee employee) {
		super();
		this.city = city;
		this.state = state;
		ZipCode = zipCode;
		this.employee = employee;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public long getZipCode() {
		return ZipCode;
	}


	public void setZipCode(long zipCode) {
		ZipCode = zipCode;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public int getAid() {
		return aid;
	}


	
	
}

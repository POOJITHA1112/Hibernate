package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	private String city;
	private String state;
	
	@ManyToOne
	private Person person;
	
	
	public Address() {
		// TODO Auto-generated constructor stub
	}


	public Address( String city, String state, Person person) {
	
		
		this.city = city;
		this.state = state;
		this.person = person;
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


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	public int getId() {
		return aid;
	}


	@Override
	public String toString() {
		return "Address [id=" + aid + ", city=" + city + ", state=" + state + ", person=" + person + "]";
	}
	
	
	
	

}

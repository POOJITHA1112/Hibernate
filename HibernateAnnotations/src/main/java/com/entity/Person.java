package com.entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "persons")


@NamedQueries({
	
	@NamedQuery(name="person.findAll",
			query = "from Person"),
	@NamedQuery(name="person.getSpecificColumns",
	query = "select firstName,lastName,date from Person"),
	@NamedQuery(name = "person.count",
	query = "select count(date)as TotalNumberOfdates from Person"),
	@NamedQuery(name = "getById",query = "select email,date from Person where id=1")
	
			
	
	
})

public class Person {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "person_id")
	// AUTO-- AUTOINCREMENT
	private long id;
	
@Column(name = "firstName", nullable = false, length = 100)
	private String firstName;
	
@Column(name = "lastName", nullable = false, length = 100)
	private String lastName;
	
@Column(name = "Email", length = 150, unique = true)
	private String email;
	
@Temporal(TemporalType.DATE)
	private Date date;

@Column(name="Salary")
private double salary;

	public Person() {
	}

	public Person(String firstName, String lastName, String email, Date date,double salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.date = date;
		this.salary=salary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double d) {
		this.salary=salary;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", date=" + date + ", salary=" + salary + "]";
	}
	
	
}

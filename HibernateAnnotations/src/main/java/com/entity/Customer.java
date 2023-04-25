package com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id

	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="customer_id")
	private int id;
	@Column(name = "customer_firstName",length = 80,nullable = false)
	private String firstName;
	@Column(name="customer_lastName",length = 80,nullable = false)
	private String lastName;
	@Column(name="customer_email",length = 180,unique = true)
	private String email;
	@Column(name = "customer_dateOfPurchase")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}



	public Customer(String firstName, String lastName, String email, Date date) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.date = date;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
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



	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", date=" + date + "]";
	}
	
	
	
	
	
	

}

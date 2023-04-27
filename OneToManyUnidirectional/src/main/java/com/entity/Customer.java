package com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String fName;
	private String lName;
	private double points;
	// this one to many annotation identifies the primary key column present in the products table
	@OneToMany
//	@JoinColumn(name ="product_id")
	private List<Products>products;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer( String fName, String lName, double points, List<Products> products) {
		
		this.fName = fName;
		this.lName = lName;
		this.points = points;
		this.products = products;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", fName=" + fName + ", lName=" + lName + ", points=" + points + ", products="
				+ products + "]";
	}
	 
	
	
	
	

}

package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int pid;
	private String name;
	private double price;
	
	public Products() {
		// TODO Auto-generated constructor stub
	}

	public Products(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Products [pid=" + pid + ", name=" + name + ", price=" + price + "]";
	}
	
}

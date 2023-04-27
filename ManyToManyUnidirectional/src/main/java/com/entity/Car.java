package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cid;
	private String brand;
	private String color;
	private double price;
	
//	@ManyToMany
//	private List<Person>persons=new ArrayList<Person>();
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	

	public long getCid() {
		return cid;
	}
	

}

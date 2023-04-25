package com.model;

public class Student {
	
	private long id;
	private String name;
	private double fees;
	
	public Student() {
		
	}

	public Student(long id, String name, double fees) {
		super();
		this.id = id;
		this.name = name;
		this.fees = fees;
	}

	public Student(String name, double fees) {
		super();
		this.name = name;
		this.fees = fees;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", fees=" + fees + "]";
	}
	
	

	

}

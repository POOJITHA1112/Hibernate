package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rillno;
	private String fName;
	private String lName;
	private String email;
	
	@OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
	private Course course;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String fName, String lName, String email, Course course) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.course = course;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getRillno() {
		return rillno;
	}
	

}

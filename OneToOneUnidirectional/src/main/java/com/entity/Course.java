package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String courseName;
	private double courseFee;
	
	@OneToOne
	private Student student;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(int cid, String courseName, double courseFee, Student student) {
		super();
		this.cid = cid;
		this.courseName = courseName;
		this.courseFee = courseFee;
		this.student = student;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getCid() {
		return cid;
	}
	

}

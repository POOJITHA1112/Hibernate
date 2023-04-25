package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fName;
	private String lName;
	private String email;
	private double salary;
	private long mblNmbr;
	
	// mapped by - giving ownership to employee class that at the time of invoking  one to many , many to one dont create extra table with the primary keys because already in parent foreign key column is created(AddressTable) 
	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
//	@JoinTable(name="emp_add_jointable",joinColumns = {@JoinColumn(name = "add_id")},inverseJoinColumns = {@JoinColumn(name = "e_id")})
	private List<Address>address;
	
	public Employee() {

	}

	public Employee(String fName, String lName, String email, double salary, long mblNmbr, List<Address> address) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.salary = salary;
		this.mblNmbr = mblNmbr;
		this.address = address;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public long getMblNmbr() {
		return mblNmbr;
	}

	public void setMblNmbr(long mblNmbr) {
		this.mblNmbr = mblNmbr;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}
	

	
	
}

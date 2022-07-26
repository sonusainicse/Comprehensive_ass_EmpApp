package com.comprehensive_assessment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This annotation is used for defining it as an Entity now this entity becomes jpa entity
@Table(name="emp") // this table annotation specify the table in the database with which this entity is mapped .
public class Employee {
	
	  
	@Id  // it define as primary key        @GeneratedValue  // auto generated values for id unique 
	private long id;
	
	@Column(name="name", nullable = false)  // it is used to define it as a column
	private String name;
	
	@Column(name="salary")
	private long salary;
	
	@Column(name="designation")
	private String designation;

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

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	

}

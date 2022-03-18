package com.nasreen.EmployeeProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	private String firstname;
	private String lastname;
	private int age;
	private int salary;
	private String designation;
	
	public Employee() {
		
	}
	
	public Employee(String firstname, String lastname, int age, int salary, String designation) {
		super();
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.salary = salary;
		this.designation = designation;
	}
	
	public int getId() {
		return id;
	}
	
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return String.format("Employee [id=%s, firstname=%s, lastname=%s, age=%s, salary=%s, designation=%s]", id,
				firstname, lastname, age, salary, designation);
	}
	
	

}

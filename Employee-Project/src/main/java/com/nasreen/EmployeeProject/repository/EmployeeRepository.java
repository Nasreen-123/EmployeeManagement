package com.nasreen.EmployeeProject.repository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.nasreen.EmployeeProject.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmployeeRepository {
	@Autowired
	EntityManager em;
	public Employee insertemployee(String firstname,String lastname, int age,int salary,String designation) {
		Employee employee=new Employee(firstname,lastname,age,salary,designation);
		em.persist(employee);
		return employee;
	}
	
	public Employee findById(Integer id)
	{
		 return em.find(Employee.class, id);
	}
	public void update(int id,int salary) {
	Employee employee =findById(id);
		employee.setSalary(salary);
		em.merge(employee);
		
	}
	public void deleteById(int id) {
		Employee employee = em.find(Employee.class, id);
		em.remove(employee);
		
	}
	

}

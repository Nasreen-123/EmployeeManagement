package com.nasreen.EmployeeProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nasreen.EmployeeProject.entity.Employee;
import com.nasreen.EmployeeProject.repository.EmployeeRepository;
@Controller
@ComponentScan(value="com.nasreen.EmployeeProject")
public class EmployeeController {
	@Autowired
	EmployeeRepository repository;
	@RequestMapping(value="/home")
	public String home() {
		return "home.jsp";
	}
	@RequestMapping(value="/create")
	public String create() {
		return "createEmployee.jsp";
	}
	@RequestMapping(value="/delete")
	public String delete() {
		return "deleteEmployee.jsp";
	}
	@RequestMapping(value="/update")
	public String update() {
		return "updateEmployee.jsp";
	}
	@RequestMapping(value="/display")
	public String display() {
		return "findById.jsp";
	}
	@RequestMapping(value="/createemployee",method=RequestMethod.POST)
	public String createEmployee(@RequestParam String firstname,@RequestParam String lastname,@RequestParam int age,@RequestParam int salary,@RequestParam String designation,ModelMap model) {
		repository.insertemployee(firstname,lastname,age,salary,designation);
		model.put("message1","User is inserted");
		return "message.jsp";
	}
	@RequestMapping(value="/findemployee")
	public String findEmployee(@RequestParam int id,ModelMap model) {
		Employee employee = repository.findById(id);
		if(employee==null) {
			model.put("message","User not found");
			return "message.jsp";
		}
		else {
		model.put("id",employee.getId());
		model.put("firstname",employee.getFirstname());
		model.put("lastname", employee.getLastname());
		model.put("age", employee.getAge());
		model.put("salary", employee.getSalary());
		model.put("designation",employee.getDesignation());
		return "details.jsp";
		}
		
	}
	@RequestMapping(value="/deleteemployee")
	public String deleteEmployee(@RequestParam int id,ModelMap model) {
		repository.deleteById(id);
		model.put("message2","User is deleted");
		return "message.jsp";
	}
	@RequestMapping(value="/updateemployee")
	public String update(@RequestParam int id,@RequestParam int salary,ModelMap model) {
		repository.update(id,salary);
		model.put("message3","User salary is updated");
		return "message.jsp";
	}


}

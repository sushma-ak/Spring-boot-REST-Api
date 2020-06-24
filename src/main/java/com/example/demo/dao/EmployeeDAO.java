package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll(); 

	
	public Employee findById(int theID);
	
	public void save(Employee  theEmployee);
	
	public void deleteById(int theId);
	
}

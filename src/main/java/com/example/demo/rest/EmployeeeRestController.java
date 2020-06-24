package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeeRestController {
	
	private EmployeeService employeeService;
	
	public EmployeeeRestController(EmployeeService theEmployeeService) {
		employeeService=theEmployeeService;
		
	}
	
	@GetMapping("/employee")
	public List<Employee> findAll()
	{
		return employeeService.findAll();
		
	}
	
	//expose "/employees" and return list of employees
	
	
	@GetMapping("/employee/{employeeId}")
	public Employee getById(@PathVariable int employeeId)
	{
		Employee theEmployee=employeeService.findById(employeeId);
		if(theEmployee==null)
			{
			throw new RuntimeException("Employee is not found -"+employeeId);
			}
		return theEmployee;
	}
	
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee theEmployee)
	{
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
		
	}
	
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee theEmployee)
	{
		employeeService.save(theEmployee);
		return theEmployee;
		
	}
	
	
	@DeleteMapping("/employee/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId)
	{
		
		Employee theEmployee=employeeService.findById(employeeId);
		if(theEmployee==null)
		{
			throw new RuntimeException("Employee id not found -"+employeeId);
			
		}
		employeeService.deleteById(employeeId);
		return "Deleted employee id -"+employeeId;
	}

	

	
	
}

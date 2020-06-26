package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;


@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager)
	{
		entityManager=theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		Query thequery=entityManager.createQuery("from Employee");
		List<Employee> employees=thequery.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int theID) {
		Employee theEmployee=entityManager.find(Employee.class,theID);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		Employee dbEmployee=entityManager.merge(theEmployee);
		dbEmployee.setId(dbEmployee.getId());
		
		
		
		
	}

	@Override
	public void deleteById(int theId) {
		//Query theQuery=entityManager.createQuery("delete from employee where id=:employeeId");
		//theQuery.setParameter("employeeId",theId);
		//theQuery.executeUpdate();
		
		Query theQuery=entityManager.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId",theId);
		theQuery.executeUpdate();
		
	}

}

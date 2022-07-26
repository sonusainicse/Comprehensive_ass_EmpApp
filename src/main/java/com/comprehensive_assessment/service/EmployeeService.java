package com.comprehensive_assessment.service;

import java.util.List;

import com.comprehensive_assessment.model.Employee;


public interface EmployeeService {
	
    Employee saveEmployee(Employee emp);
	
	List<Employee> getAllEmployees();
	
	public List<Employee> getAllEmployeesDescendingOrderbysalary();
	
	Employee getEmployeeById(long id);
	
	public Employee updateEmployee(Employee emp);
	
	void deleteEmployeeById(long id);

}

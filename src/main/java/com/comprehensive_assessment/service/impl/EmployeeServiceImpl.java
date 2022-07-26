package com.comprehensive_assessment.service.impl;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.comprehensive_assessment.exception.IdAlreadyExistsExcetion;
import com.comprehensive_assessment.exception.ResourceNotFoundException;
import com.comprehensive_assessment.model.Employee;
import com.comprehensive_assessment.repository.EmployeeRepository;
import com.comprehensive_assessment.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	private	EmployeeRepository employeeRepository ;

		public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


		@Override
		public Employee saveEmployee(Employee employee) {
		
			if(employeeRepository.existsById(employee.getId())) {
				
				throw new IdAlreadyExistsExcetion("This id is already exists in the database go with other id");
			}
			
			
			return employeeRepository.save(employee);
		}



		@Override
		public Employee getEmployeeById(long id) {
			java.util.Optional<Employee> optional = employeeRepository.findById(id);
			Employee employee = null;
			if (optional.isPresent()) {
				employee = optional.get();
			} else {
				throw new ResourceNotFoundException("Employee", "ID",id);
			}
			return employee;
		}


		@Override
		public void deleteEmployeeById(long id) {
			this.employeeRepository.deleteById(id);
		}



		@Override
		public java.util.List<Employee> getAllEmployees() {
			 return employeeRepository.findAll();
		}


		@Override
		public List<Employee> getAllEmployeesDescendingOrderbysalary() {
			List<Employee> list = employeeRepository.findAll();

			list.sort(new Comparator<Employee>() {
				@Override
				public int compare(Employee o1, Employee o2) {
					
					if(o2.getSalary()==o1.getSalary()) {
						
						return o1.getName().compareTo(o2.getName());
					}
					return (int) (o2.getSalary()-o1.getSalary());
				}

			});

			return list;
		}


		@Override
		public Employee updateEmployee(Employee emp) {
			Employee ExistingEmployee = employeeRepository.findById(emp.getId()).orElse(null);
			ExistingEmployee.setName(emp.getName());
			ExistingEmployee.setSalary(emp.getSalary());
			ExistingEmployee.setDesignation(emp.getDesignation());
			return employeeRepository.save(ExistingEmployee);
		}

	}


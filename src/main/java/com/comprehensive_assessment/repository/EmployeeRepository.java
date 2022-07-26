package com.comprehensive_assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comprehensive_assessment.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

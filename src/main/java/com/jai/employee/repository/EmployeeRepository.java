package com.jai.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jai.employee.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

}

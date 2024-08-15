package com.jai.employee.service;

import java.util.List;

import com.jai.employee.dto.EmployeeDto;

public interface EmployeeService {
 public EmployeeDto createEmployee(EmployeeDto emp);
 
 public EmployeeDto getEmployeeById(Long employeeId);
 
 public List<EmployeeDto> getAllEmployee();
 
 public EmployeeDto updateEmployee(Long employeeId,EmployeeDto updateEmployee);
 
 public void deleteEmployee(Long employeeId);
 
}

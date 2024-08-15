package com.jai.employee.mapper;

import com.jai.employee.dto.EmployeeDto;
import com.jai.employee.entity.Employee;

public class EmployeeMapper {

	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail()
				);
	}
	public static Employee mapToEmployee(EmployeeDto employee) {
		return new Employee(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail()
				);
	}
	
	
}

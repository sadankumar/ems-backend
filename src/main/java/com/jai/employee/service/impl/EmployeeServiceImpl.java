package com.jai.employee.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jai.employee.dto.EmployeeDto;
import com.jai.employee.entity.Employee;
import com.jai.employee.exception.ResourceNotFoundException;
import com.jai.employee.mapper.EmployeeMapper;
import com.jai.employee.repository.EmployeeRepository;
import com.jai.employee.service.EmployeeService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
  private EmployeeRepository employeeRepository;
	@Override
	public EmployeeDto createEmployee(EmployeeDto emp) {
		Employee employee=EmployeeMapper.mapToEmployee(emp);
		Employee savedEmp= employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmp);
	}
	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee= employeeRepository.findById(employeeId).
		   orElseThrow(()-> new ResourceNotFoundException("Employee not found with the given Id= "+employeeId));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}
	@Override
	public List<EmployeeDto> getAllEmployee() {
	 List<Employee> employeeList=employeeRepository.findAll();
		return employeeList.stream().
				map((employee)->EmployeeMapper.
						mapToEmployeeDto(employee)).collect(Collectors.toList());
	}
	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
		 Employee savedemp=employeeRepository.
				 findById(employeeId).
				 orElseThrow(()->
				 new ResourceNotFoundException("Employee not found with the given id="+employeeId));
		 savedemp.setFirstName(updateEmployee.getFirstName());
		 savedemp.setLastName(updateEmployee.getLastName());
		 savedemp.setEmail(updateEmployee.getEmail());
		 return EmployeeMapper.mapToEmployeeDto(employeeRepository.save(savedemp)) ;
	}
	@Override
	public void deleteEmployee(Long employeeId) {
		Employee savedemp=employeeRepository.
				 findById(employeeId).
				 orElseThrow(()->
				 new ResourceNotFoundException("Employee not found with the given id="+employeeId));
		employeeRepository.deleteById(employeeId);
	}

}

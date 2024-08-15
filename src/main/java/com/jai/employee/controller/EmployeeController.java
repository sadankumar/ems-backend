package com.jai.employee.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jai.employee.dto.EmployeeDto;
import com.jai.employee.service.EmployeeService;

import lombok.AllArgsConstructor;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
	
private EmployeeService employeeService;
@PostMapping
public ResponseEntity<EmployeeDto> createEmployee(@RequestBody  EmployeeDto emp){
EmployeeDto savedEmp=employeeService.createEmployee(emp);
return new ResponseEntity<EmployeeDto>(savedEmp,HttpStatus.CREATED);

}
@GetMapping("{id}")
public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
	EmployeeDto empDto=employeeService.getEmployeeById(employeeId);
	return ResponseEntity.ok(empDto);
}

@GetMapping
public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
	List<EmployeeDto> employeeList= employeeService.getAllEmployee();
	return ResponseEntity.ok(employeeList);
}

@PutMapping("{id}")
public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto empDto){
	EmployeeDto employeeDto= employeeService.updateEmployee(employeeId,empDto);
	return ResponseEntity.ok(employeeDto);
}
@DeleteMapping("{id}")
public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
	 employeeService.deleteEmployee(employeeId);;
	return ResponseEntity.ok("Employee deleted successfully");
}


}

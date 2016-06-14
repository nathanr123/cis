package com.cti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cti.model.Employee;

@Transactional
public interface EmployeeService {
	
public boolean saveEmployee(Employee emp);
	
	public boolean updateEmployee(Employee emp);
	
	public boolean removeEmployee(String empname);
	
	public Employee getEmployeeById(String empname);
	
	public String getLatestGroupID();

	public List<Employee> listEmployees();	
	
	public List<Employee> listEmployees(List<String> employeeList);
}

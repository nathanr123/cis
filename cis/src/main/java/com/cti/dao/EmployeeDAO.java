package com.cti.dao;

import java.util.List;

import com.cti.model.Employee;

public interface EmployeeDAO {
	
	public boolean saveEmployee(Employee emp);
	
	public boolean updateEmployee(Employee emp);
	
	public boolean removeEmployee(String empname);
	
	public Employee getEmployeeById(String empname);
	
	public String getLatestGroupID();

	public List<Employee> listEmployees();	
	
	public List<Employee> listEmployees(List<String> employeeList);
}

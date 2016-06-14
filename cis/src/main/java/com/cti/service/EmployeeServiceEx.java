/**
 * 
 */
package com.cti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cti.dao.EmployeeDAO;
import com.cti.model.Employee;

/**
 * @author nathanr_kamal
 *
 */
@Service
public class EmployeeServiceEx implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#saveUser(com.cti.model.User)
	 */
	@Override
	public boolean saveEmployee(Employee emp) {
		return employeeDAO.saveEmployee(emp);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#updateUser(com.cti.model.User)
	 */
	@Override
	public boolean updateEmployee(Employee emp) {
		return employeeDAO.updateEmployee(emp);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#removeUser(java.lang.String)
	 */
	@Override
	public boolean removeEmployee(String empname) {
		return employeeDAO.removeEmployee(empname);
	}
	
	@Override
	public String getLatestGroupID() {
		return employeeDAO.getLatestGroupID();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#getUserById(java.lang.String)
	 */
	@Override
	public Employee getEmployeeById(String empname) {
		return employeeDAO.getEmployeeById(empname);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#listUsers()
	 */
	@Override
	public List<Employee> listEmployees() {
		return employeeDAO.listEmployees();
	}

	@Override
	public List<Employee> listEmployees(List<String> employeeList) {
		// TODO Auto-generated method stub
		return employeeDAO.listEmployees(employeeList);
	}

}

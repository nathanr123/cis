/**
 * 
 */
package com.cti.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.cti.model.Employee;
//import com.cti.model.UserGroup;
import com.cti.model.User;

/**
 * @author nathanr_kamal
 *
 */
@Repository
public class EmployeeDAOEx implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;


	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean saveEmployee(Employee emp) {
		try {
			

			getCurrentSession().save(emp);

			return true;

		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean updateEmployee(Employee emp) {
		try {
			getCurrentSession().update(emp);
			return true;
		} catch (Exception e) {
		
			e.printStackTrace();
			return false;
		}

	}
	 

		@Override
		public Employee getEmployeeById(String emp) {
			Employee empl = (Employee) getCurrentSession().get(Employee.class, emp);
			return empl;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.cti.dao.GroupDAO#listGroups()
		 */
		@SuppressWarnings("unchecked")
		@Override
		public List<Employee> listEmployees() {

			return getCurrentSession().createQuery("from Employee").list();

		}

		@Override
		public List<Employee> listEmployees(List<String> grpList) {
			if (grpList != null) {
				List<Employee> userGroupList = new ArrayList<Employee>();

				for (Iterator<String> iterator = grpList.iterator(); iterator
						.hasNext();) {
					String group = iterator.next();

					userGroupList.add(getEmployeeById(group));

				}
				return userGroupList;
			} else
				return null;
		}
	

	@Override
	public String getLatestGroupID() {

		Query query = getCurrentSession().createQuery(
				"SELECT MAX(empid) FROM Employee");

		return (String) query.list().get(0);

	}
	
	
	@Override
	public boolean removeEmployee(String employeename) {

		return deleteAllEmployeeRecords(employeename);
	}

	private String getDeleteQuery(String table, String empname) {

		return String.format("DELETE FROM %s WHERE empid= \'%s\'", table,
				empname);
	}

	private List<String> getAllDeletingQueries(String empname) {

		List<String> qryList = new ArrayList<String>();

		Iterator<String> it = getAllEmployeeChildNames().iterator();

		while (it.hasNext()) {
			qryList.add(getDeleteQuery(it.next(), empname));
		}

		return qryList;
	}

	private boolean deleteAllEmployeeRecords(String empname) {

		try {
			Session session = getCurrentSession();

			List<String> it = getAllDeletingQueries(empname);

			for (Iterator<String> iterator = it.iterator(); iterator.hasNext();) {

				session.createQuery(iterator.next()).executeUpdate();
			}

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Set<String> getAllEmployeeChildNames() {

		LinkedHashSet<String> childList = new LinkedHashSet<String>();

		childList.add(Employee.class.getName());

		return childList;
	}
}

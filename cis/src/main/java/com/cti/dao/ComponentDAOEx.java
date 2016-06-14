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

import com.cti.model.Component;
//import com.cti.model.UserGroup;


/**
 * @author nathanr_kamal
 *
 */
@Repository
public class ComponentDAOEx implements ComponentDAO {

	@Autowired
	private SessionFactory sessionFactory;


	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean saveComponent(Component emp) {
		try {
			

			getCurrentSession().save(emp);

			return true;

		} catch (Exception e) { 
			
			return false;
		}

	}

	@Override
	public boolean updateComponent(Component emp) {
		try {
			getCurrentSession().update(emp);
			return true;
		} catch (Exception e) {
		
			e.printStackTrace();
			return false;
		}

	}
	 

		@Override
		public Component getComponentById(String emp) {
			Component empl = (Component) getCurrentSession().get(Component.class, emp);
			return empl;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.cti.dao.GroupDAO#listGroups()
		 */
		@SuppressWarnings("unchecked")
		@Override
		public List<Component> listComponent() {

			return getCurrentSession().createQuery("from Component").list();

		}

		@Override
		public List<Component> listComponent(List<String> grpList) {
			if (grpList != null) {
				List<Component> userGroupList = new ArrayList<Component>();

				for (Iterator<String> iterator = grpList.iterator(); iterator
						.hasNext();) {
					String group = iterator.next();

					userGroupList.add(getComponentById(group));

				}
				return userGroupList;
			} else
				return null;
		}
	

	@Override
	public String getLatestComponentID() {

		Query query = getCurrentSession().createQuery(
				"SELECT MAX(comp_ID) FROM Component");

		return (String) query.list().get(0);

	}
	
	
	@Override
	public boolean removeComponent(String employeename) {

		return deleteAllComponentRecords(employeename);
	}

	private String getDeleteQuery(String table, String empname) {

		return String.format("DELETE FROM %s WHERE comp_ID= \'%s\'", table,
				empname);
	}

	private List<String> getAllDeletingQueries(String empname) {

		List<String> qryList = new ArrayList<String>();

		Iterator<String> it = getAllComponentChildNames().iterator();

		while (it.hasNext()) {
			qryList.add(getDeleteQuery(it.next(), empname));
		}

		return qryList;
	}

	private boolean deleteAllComponentRecords(String empname) {

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

	public Set<String> getAllComponentChildNames() {

		LinkedHashSet<String> childList = new LinkedHashSet<String>();

		childList.add(Component.class.getName());

		return childList;
	}
}

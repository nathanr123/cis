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

import com.cti.model.Client;
//import com.cti.model.UserGroup;


/**
 * @author nathanr_kamal
 *
 */
@Repository
public class ClientDAOEx implements ClientDAO {

	@Autowired
	private SessionFactory sessionFactory;


	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean saveClient(Client emp) {
		try {
			

			getCurrentSession().save(emp);

			return true;

		} catch (Exception e) { 
			
			return false;
		}

	}

	@Override
	public boolean updateClient(Client emp) {
		try {
			getCurrentSession().update(emp);
			return true;
		} catch (Exception e) {
		
			e.printStackTrace();
			return false;
		}

	}
	 

		@Override
		public Client getClientById(String emp) {
			Client empl = (Client) getCurrentSession().get(Client.class, emp);
			return empl;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.cti.dao.GroupDAO#listGroups()
		 */
		@SuppressWarnings("unchecked")
		@Override
		public List<Client> listClient() {

			return getCurrentSession().createQuery("from Client").list();

		}

		@Override
		public List<Client> listClient(List<String> grpList) {
			if (grpList != null) {
				List<Client> userGroupList = new ArrayList<Client>();

				for (Iterator<String> iterator = grpList.iterator(); iterator
						.hasNext();) {
					String group = iterator.next();

					userGroupList.add(getClientById(group));

				}
				return userGroupList;
			} else
				return null;
		}
	

	@Override
	public String getLatestClientID() {

		Query query = getCurrentSession().createQuery(
				"SELECT MAX(client_ID) FROM Client");

		return (String) query.list().get(0);

	}
	
	
	
	
	@Override
	public boolean removeClient(String employeename) {

		return deleteAllClientRecords(employeename);
	}

	private String getDeleteQuery(String table, String empname) {

		return String.format("DELETE FROM %s WHERE client_ID= \'%s\'", table,
				empname);
	}

	private List<String> getAllDeletingQueries(String empname) {

		List<String> qryList = new ArrayList<String>();

		Iterator<String> it = getAllClientChildNames().iterator();

		while (it.hasNext()) {
			qryList.add(getDeleteQuery(it.next(), empname));
		}

		return qryList;
	}

	private boolean deleteAllClientRecords(String empname) {

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

	public Set<String> getAllClientChildNames() {

		LinkedHashSet<String> childList = new LinkedHashSet<String>();

		childList.add(Client.class.getName());

		return childList;
	}
}

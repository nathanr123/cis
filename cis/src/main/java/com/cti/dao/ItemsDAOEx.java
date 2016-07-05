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

import com.cti.model.Items;
//import com.cti.model.UserGroup;


/**
 * @author nathanr_kamal
 *
 */
@Repository
public class ItemsDAOEx implements ItemsDAO {

	@Autowired
	private SessionFactory sessionFactory;


	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean saveItems(Items items) {
		try {
			

			getCurrentSession().save(items);

			return true;

		} catch (Exception e) { 
			
			return false;
		}

	}

	@Override
	public boolean updateItems(Items items) {
		try {
			getCurrentSession().update(items);
			return true;
		} catch (Exception e) {
		
			e.printStackTrace();
			return false;
		}

	}
	 

		@Override
		public Items getItemsById(String items) {
			Items itemsl = (Items) getCurrentSession().get(Items.class, items);
			return itemsl;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.cti.dao.GroupDAO#listGroups()
		 */
		@SuppressWarnings("unchecked")
		@Override
		public List<Items> listItems() {

			return getCurrentSession().createQuery("from Items").list();

		}

		@Override
		public List<Items> listItems(List<String> grpList) {
			if (grpList != null) {
				List<Items> userGroupList = new ArrayList<Items>();

				for (Iterator<String> iterator = grpList.iterator(); iterator
						.hasNext();) {
					String group = iterator.next();

					userGroupList.add(getItemsById(group));

				}
				return userGroupList;
			} else
				return null;
		}
	

	@Override
	public String getLatestItemsID() {

		Query query = getCurrentSession().createQuery(
				"SELECT MAX(product_ID) FROM Items");

		return (String) query.list().get(0);

	}
	
	
	@Override
	public boolean removeItems(String items) {

		return deleteAllItemsRecords(items);
	}

	private String getDeleteQuery(String table, String items) {

		return String.format("DELETE FROM %s WHERE product_ID= \'%s\'", table,
				items);
	}

	private List<String> getAllDeletingQueries(String items) {

		List<String> qryList = new ArrayList<String>();

		Iterator<String> it = getAllItemsChildNames().iterator();

		while (it.hasNext()) {
			qryList.add(getDeleteQuery(it.next(), items));
		}

		return qryList;
	}

	private boolean deleteAllItemsRecords(String items) {

		try {
			Session session = getCurrentSession();

			List<String> it = getAllDeletingQueries(items);

			for (Iterator<String> iterator = it.iterator(); iterator.hasNext();) {

				session.createQuery(iterator.next()).executeUpdate();
			}

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Set<String> getAllItemsChildNames() {

		LinkedHashSet<String> childList = new LinkedHashSet<String>();

		childList.add(Items.class.getName());

		return childList;
	}
}

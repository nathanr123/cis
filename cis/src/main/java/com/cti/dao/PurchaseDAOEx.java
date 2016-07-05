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
import com.cti.model.Invoice;
import com.cti.model.Purchase;
//import com.cti.model.UserGroup;


/**
 * @author nathanr_kamal
 *
 */
@Repository
public class PurchaseDAOEx implements PurchaseDAO {

	@Autowired
	private SessionFactory sessionFactory;


	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean savePurchase(Purchase purchase) {
		try {
			

			getCurrentSession().save(purchase);

			return true;

		} catch (Exception e) { 
			
			return false;
		}

	}

	@Override
	public boolean updatePurchase(Purchase purchase) {
		try {
			getCurrentSession().update(purchase);
			return true;
		} catch (Exception e) {
		
			e.printStackTrace();
			return false;
		}

	}
	 

		@Override
		public Purchase getPurchaseById(String purchase) {
			Purchase purchasel = (Purchase) getCurrentSession().get(Purchase.class, purchase);
			return purchasel;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.cti.dao.GroupDAO#listGroups()
		 */
		@SuppressWarnings("unchecked")
		@Override
		public List<Purchase> listPurchase() {

			return getCurrentSession().createQuery("from Purchase").list();

		}

		@Override
		public List<Purchase> listPurchase(List<String> grpList) {
			if (grpList != null) {
				List<Purchase> userGroupList = new ArrayList<Purchase>();

				for (Iterator<String> iterator = grpList.iterator(); iterator
						.hasNext();) {
					String group = iterator.next();

					userGroupList.add(getPurchaseById(group));

				}
				return userGroupList;
			} else
				return null;
		}
	

	@Override
	public String getLatestPurchaseID() {

		Query query = getCurrentSession().createQuery(
				"SELECT MAX(purchase_ID) FROM Purchase");

		return (String) query.list().get(0);

	}
	
	
	@Override
	public boolean removePurchase(String purchase) {

		return deleteAllPurchaseRecords(purchase);
	}

	private String getDeleteQuery(String table, String purchase) {

		return String.format("DELETE FROM %s WHERE purchase_ID= \'%s\'", table,
				purchase);
	}

	private List<String> getAllDeletingQueries(String purchase) {

		List<String> qryList = new ArrayList<String>();

		Iterator<String> it = getAllPurchaseChildNames().iterator();

		while (it.hasNext()) {
			qryList.add(getDeleteQuery(it.next(), purchase));
		}

		return qryList;
	}

	private boolean deleteAllPurchaseRecords(String purchase) {

		try {
			Session session = getCurrentSession();

			List<String> it = getAllDeletingQueries(purchase);

			for (Iterator<String> iterator = it.iterator(); iterator.hasNext();) {

				session.createQuery(iterator.next()).executeUpdate();
			}

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Set<String> getAllPurchaseChildNames() {

		LinkedHashSet<String> childList = new LinkedHashSet<String>();

		childList.add(Purchase.class.getName());

		return childList;
	}
	
	@Override
	public List<Client> getCust() {
		// TODO Auto-generated method stub
		return getCurrentSession().createQuery("FROM Client").list();
	}
}

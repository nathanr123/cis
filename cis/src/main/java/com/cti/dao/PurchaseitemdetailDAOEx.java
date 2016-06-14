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

import com.cti.model.Purchaseitemdetail;
//import com.cti.model.UserGroup;


/**
 * @author nathanr_kamal
 *
 */
@Repository
public class PurchaseitemdetailDAOEx implements PurchaseitemdetailDAO {

	@Autowired
	private SessionFactory sessionFactory;


	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean savePurchaseitemdetail(Purchaseitemdetail emp) {
		try {
			

			getCurrentSession().save(emp);

			return true;

		} catch (Exception e) { 
			
			return false;
		}

	}

	@Override
	public boolean updatePurchaseitemdetail(Purchaseitemdetail emp) {
		try {
			getCurrentSession().update(emp);
			return true;
		} catch (Exception e) {
		
			e.printStackTrace();
			return false;
		}

	}
	 

		@Override
		public Purchaseitemdetail getPurchaseitemdetailById(String emp) {
			Purchaseitemdetail empl = (Purchaseitemdetail) getCurrentSession().get(Purchaseitemdetail.class, emp);
			return empl;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.cti.dao.GroupDAO#listGroups()
		 */
		@SuppressWarnings("unchecked")
		@Override
		public List<Purchaseitemdetail> listPurchaseitemdetail() {

			return getCurrentSession().createQuery("from Purchaseitemdetail").list();

		}

		@Override
		public List<Purchaseitemdetail> listPurchaseitemdetail(List<String> grpList) {
			if (grpList != null) {
				List<Purchaseitemdetail> userGroupList = new ArrayList<Purchaseitemdetail>();

				for (Iterator<String> iterator = grpList.iterator(); iterator
						.hasNext();) {
					String group = iterator.next();

					userGroupList.add(getPurchaseitemdetailById(group));

				}
				return userGroupList;
			} else
				return null;
		}
	

	@Override
	public String getLatestPurchaseitemdetailID() {

		Query query = getCurrentSession().createQuery(
				"SELECT MAX(product_ID) FROM Purchaseitemdetail");

		return (String) query.list().get(0);

	}
	
	
	@Override
	public boolean removePurchaseitemdetail(String employeename) {

		return deleteAllPurchaseitemdetailRecords(employeename);
	}

	private String getDeleteQuery(String table, String empname) {

		return String.format("DELETE FROM %s WHERE product_ID= \'%s\'", table,
				empname);
	}

	private List<String> getAllDeletingQueries(String empname) {

		List<String> qryList = new ArrayList<String>();

		Iterator<String> it = getAllPurchaseitemdetailChildNames().iterator();

		while (it.hasNext()) {
			qryList.add(getDeleteQuery(it.next(), empname));
		}

		return qryList;
	}

	private boolean deleteAllPurchaseitemdetailRecords(String empname) {

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

	public Set<String> getAllPurchaseitemdetailChildNames() {

		LinkedHashSet<String> childList = new LinkedHashSet<String>();

		childList.add(Purchaseitemdetail.class.getName());

		return childList;
	}
}

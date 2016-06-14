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

import com.cti.model.Invoiceitemdetail;
//import com.cti.model.UserGroup;


/**
 * @author nathanr_kamal
 *
 */
@Repository
public class InvoiceitemdetailDAOEx implements InvoiceitemdetailDAO {

	@Autowired
	private SessionFactory sessionFactory;


	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean saveInvoiceitemdetail(Invoiceitemdetail emp) {
		try {
			

			getCurrentSession().save(emp);

			return true;

		} catch (Exception e) { 
			
			return false;
		}

	}

	@Override
	public boolean updateInvoiceitemdetail(Invoiceitemdetail emp) {
		try {
			getCurrentSession().update(emp);
			return true;
		} catch (Exception e) {
		
			e.printStackTrace();
			return false;
		}

	}
	 

		@Override
		public Invoiceitemdetail getInvoiceitemdetailById(String emp) {
			Invoiceitemdetail empl = (Invoiceitemdetail) getCurrentSession().get(Invoiceitemdetail.class, emp);
			return empl;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.cti.dao.GroupDAO#listGroups()
		 */
		@SuppressWarnings("unchecked")
		@Override
		public List<Invoiceitemdetail> listInvoiceitemdetail() {

			return getCurrentSession().createQuery("from Invoiceitemdetail").list();

		}

		@Override
		public List<Invoiceitemdetail> listInvoiceitemdetail(List<String> grpList) {
			if (grpList != null) {
				List<Invoiceitemdetail> userGroupList = new ArrayList<Invoiceitemdetail>();

				for (Iterator<String> iterator = grpList.iterator(); iterator
						.hasNext();) {
					String group = iterator.next();

					userGroupList.add(getInvoiceitemdetailById(group));

				}
				return userGroupList;
			} else
				return null;
		}
	

	@Override
	public String getLatestInvoiceitemdetailID() {

		Query query = getCurrentSession().createQuery(
				"SELECT MAX(product_ID) FROM Invoiceitemdetail");

		return (String) query.list().get(0);

	}
	
	
	@Override
	public boolean removeInvoiceitemdetail(String employeename) {

		return deleteAllInvoiceitemdetailRecords(employeename);
	}

	private String getDeleteQuery(String table, String empname) {

		return String.format("DELETE FROM %s WHERE product_ID= \'%s\'", table,
				empname);
	}

	private List<String> getAllDeletingQueries(String empname) {

		List<String> qryList = new ArrayList<String>();

		Iterator<String> it = getAllInvoiceitemdetailChildNames().iterator();

		while (it.hasNext()) {
			qryList.add(getDeleteQuery(it.next(), empname));
		}

		return qryList;
	}

	private boolean deleteAllInvoiceitemdetailRecords(String empname) {

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

	public Set<String> getAllInvoiceitemdetailChildNames() {

		LinkedHashSet<String> childList = new LinkedHashSet<String>();

		childList.add(Invoiceitemdetail.class.getName());

		return childList;
	}
}

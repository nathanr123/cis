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
	public boolean saveInvoiceitemdetail(Invoiceitemdetail invoice) {
		try {
			

			getCurrentSession().save(invoice);

			return true;

		} catch (Exception e) { 
			
			return false;
		}

	}

	@Override
	public boolean updateInvoiceitemdetail(Invoiceitemdetail invoice) {
		try {
			getCurrentSession().update(invoice);
			return true;
		} catch (Exception e) {
		
			e.printStackTrace();
			return false;
		}

	}
	 

		@Override
		public Invoiceitemdetail getInvoiceitemdetailById(String invoice) {
			Invoiceitemdetail invoicel = (Invoiceitemdetail) getCurrentSession().get(Invoiceitemdetail.class, invoice);
			return invoicel;
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
		public List<Invoiceitemdetail> listInvoiceitemdetail(String id) {

						 
			return getCurrentSession().createQuery(String.format("FROM Invoiceitemdetail WHERE invoicenumber= \'%s\'",id)).list();

		}


	@Override
	public String getLatestInvoiceitemdetailID() {

		Query query = getCurrentSession().createQuery(
				"SELECT MAX(product_ID) FROM Invoiceitemdetail");

		return (String) query.list().get(0);

	}
	
	
	@Override
	public boolean removeInvoiceitemdetail(String invoice) {

		return deleteAllInvoiceitemdetailRecords(invoice);
	}

	private String getDeleteQuery(String table, String invoice) {

		return String.format("DELETE FROM %s WHERE invoicenumber= \'%s\'", table,
				invoice);
	}

	private List<String> getAllDeletingQueries(String invoice) {

		List<String> qryList = new ArrayList<String>();

		Iterator<String> it = getAllInvoiceitemdetailChildNames().iterator();

		while (it.hasNext()) {
			qryList.add(getDeleteQuery(it.next(), invoice));
		}

		return qryList;
	}

	private boolean deleteAllInvoiceitemdetailRecords(String invoice) {

		try {
			Session session = getCurrentSession();

			List<String> it = getAllDeletingQueries(invoice);

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
	
	@Override
	public List<Invoice> getInv() {
		// TODO Auto-generated method stub
		return getCurrentSession().createQuery("FROM Invoice").list();
	}
	
}

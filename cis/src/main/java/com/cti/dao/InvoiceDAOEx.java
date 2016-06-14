/**
 * 
 */
package com.cti.dao;

import java.util.ArrayList;
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
public class InvoiceDAOEx implements InvoiceDAO {

	@Autowired
	private SessionFactory sessionFactory;


	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean saveInvoice(Invoice emp) {
		try {
			

			getCurrentSession().save(emp);

			return true;

		} catch (Exception e) { 
			
			return false;
		}

	}

	@Override
	public boolean updateInvoice(Invoice emp) {
		try {
			getCurrentSession().update(emp);
			return true;
		} catch (Exception e) {
		
			e.printStackTrace();
			return false;
		}

	}
	 

		@Override
		public Invoice getInvoiceById(String emp) {
			Invoice empl = (Invoice) getCurrentSession().get(Invoice.class, emp);
			return empl;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.cti.dao.GroupDAO#listGroups()
		 */
		@SuppressWarnings("unchecked")
		@Override
		public List<Invoice> listInvoice() {

			return getCurrentSession().createQuery("from Invoice").list();

		}

		@Override
		public List<Invoice> listInvoice(List<String> grpList) {
			if (grpList != null) {
				List<Invoice> userGroupList = new ArrayList<Invoice>();

				for (Iterator<String> iterator = grpList.iterator(); iterator
						.hasNext();) {
					String group = iterator.next();

					userGroupList.add(getInvoiceById(group));

				}
				return userGroupList;
			} else
				return null;
		}
	

	@Override
	public String getLatestInvoiceID() {

		Query query = getCurrentSession().createQuery(
				"SELECT MAX(invoice_ID) FROM Invoice");

		return (String) query.list().get(0);

	}
	
	
	@Override
	public boolean removeInvoice(String employeename) {

		return deleteAllInvoiceRecords(employeename);
	}

	private String getDeleteQuery(String table, String empname) {

		return String.format("DELETE FROM %s WHERE invoice_ID= \'%s\'", table,
				empname);
	}

	private List<String> getAllDeletingQueries(String empname) {

		List<String> qryList = new ArrayList<String>();

		Iterator<String> it = getAllInvoiceChildNames().iterator();

		while (it.hasNext()) {
			qryList.add(getDeleteQuery(it.next(), empname));
		}

		return qryList;
	}

	private boolean deleteAllInvoiceRecords(String empname) {

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

	public Set<String> getAllInvoiceChildNames() {

		LinkedHashSet<String> childList = new LinkedHashSet<String>();

		childList.add(Invoice.class.getName());

		return childList;
	}

	@Override
	public List<Client> getCust() {
		// TODO Auto-generated method stub
		return getCurrentSession().createQuery("FROM Client").list();
	}
	
	@Override
	public List<Purchase> getPur() {
		// TODO Auto-generated method stub
		return getCurrentSession().createQuery("FROM Purchase").list();
	}
}

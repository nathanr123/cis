/**
 * 
 */
package com.cti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cti.dao.InvoiceDAO;
import com.cti.model.Client;
import com.cti.model.Invoice;
import com.cti.model.Purchase;

/**
 * @author nathanr_kamal
 *
 */
@Service
public class InvoiceServiceEx implements InvoiceService {

	@Autowired
	InvoiceDAO InvoiceDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#saveUser(com.cti.model.User)
	 */
	@Override
	public boolean saveInvoice(Invoice it) {
		return InvoiceDAO.saveInvoice(it);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#updateUser(com.cti.model.User)
	 */
	@Override
	public boolean updateInvoice(Invoice it) {
		return InvoiceDAO.updateInvoice(it);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#removeUser(java.lang.String)
	 */
	@Override
	public boolean removeInvoice(String it) {
		return InvoiceDAO.removeInvoice(it);
	}
	
	@Override
	public String getLatestInvoiceID() {
		return InvoiceDAO.getLatestInvoiceID();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#getUserById(java.lang.String)
	 */
	@Override
	public Invoice getInvoiceById(String it) {
		return InvoiceDAO.getInvoiceById(it);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#listUsers()
	 */
	@Override
	public List<Invoice> listInvoice() {
		return InvoiceDAO.listInvoice();
	}

	@Override
	public List<Invoice> listInvoice(List<String> InvoiceList) {
		// TODO Auto-generated method stub
		return InvoiceDAO.listInvoice(InvoiceList);
	}

	@Override
	public List<Client> getCust() {
		// TODO Auto-generated method stub
		return InvoiceDAO.getCust();
		
	}
	
	@Override
	public List<Purchase> getPur() {
		// TODO Auto-generated method stub
		return InvoiceDAO.getPur();
		
	}

}

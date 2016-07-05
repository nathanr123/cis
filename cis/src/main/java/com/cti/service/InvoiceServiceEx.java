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
	public boolean saveInvoice(Invoice invoice) {
		return InvoiceDAO.saveInvoice(invoice);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#updateUser(com.cti.model.User)
	 */
	@Override
	public boolean updateInvoice(Invoice invoice) {
		return InvoiceDAO.updateInvoice(invoice);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#removeUser(java.lang.String)
	 */
	@Override
	public boolean removeInvoice(String invoice) {
		return InvoiceDAO.removeInvoice(invoice);
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
	public Invoice getInvoiceById(String invoice) {
		return InvoiceDAO.getInvoiceById(invoice);
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

/**
 * 
 */
package com.cti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cti.dao.InvoiceitemdetailDAO;
import com.cti.model.Invoiceitemdetail;

/**
 * @author nathanr_kamal
 *
 */
@Service
public class InvoiceitemdetailServiceEx implements InvoiceitemdetailService {

	@Autowired
	InvoiceitemdetailDAO InvoiceitemdetailDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#saveUser(com.cti.model.User)
	 */
	@Override
	public boolean saveInvoiceitemdetail(Invoiceitemdetail it) {
		return InvoiceitemdetailDAO.saveInvoiceitemdetail(it);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#updateUser(com.cti.model.User)
	 */
	@Override
	public boolean updateInvoiceitemdetail(Invoiceitemdetail it) {
		return InvoiceitemdetailDAO.updateInvoiceitemdetail(it);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#removeUser(java.lang.String)
	 */
	@Override
	public boolean removeInvoiceitemdetail(String it) {
		return InvoiceitemdetailDAO.removeInvoiceitemdetail(it);
	}
	
	@Override
	public String getLatestInvoiceitemdetailID() {
		return InvoiceitemdetailDAO.getLatestInvoiceitemdetailID();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#getUserById(java.lang.String)
	 */
	@Override
	public Invoiceitemdetail getInvoiceitemdetailById(String it) {
		return InvoiceitemdetailDAO.getInvoiceitemdetailById(it);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#listUsers()
	 */
	@Override
	public List<Invoiceitemdetail> listInvoiceitemdetail() {
		return InvoiceitemdetailDAO.listInvoiceitemdetail();
	}

	@Override
	public List<Invoiceitemdetail> listInvoiceitemdetail(List<String> InvoiceitemdetailList) {
		// TODO Auto-generated method stub
		return InvoiceitemdetailDAO.listInvoiceitemdetail(InvoiceitemdetailList);
	}

}

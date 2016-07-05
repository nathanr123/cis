/**
 * 
 */
package com.cti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cti.dao.InvoiceitemdetailDAO;
import com.cti.model.Invoice;
import com.cti.model.Invoiceitemdetail;

/**
 * @author nathanr_kamal
 *
 */
@Service
public class InvoiceitemdetailServiceEx implements InvoiceitemdetailService {

	@Autowired
	InvoiceitemdetailDAO invoiceitemdetailDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#saveUser(com.cti.model.User)
	 */
	@Override
	public boolean saveInvoiceitemdetail(Invoiceitemdetail invoiceitem) {
		return invoiceitemdetailDAO.saveInvoiceitemdetail(invoiceitem);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#updateUser(com.cti.model.User)
	 */
	@Override
	public boolean updateInvoiceitemdetail(Invoiceitemdetail invoiceitem) {
		return invoiceitemdetailDAO.updateInvoiceitemdetail(invoiceitem);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#removeUser(java.lang.String)
	 */
	@Override
	public boolean removeInvoiceitemdetail(String invoiceitem) {
		return invoiceitemdetailDAO.removeInvoiceitemdetail(invoiceitem);
	}
	
	@Override
	public String getLatestInvoiceitemdetailID() {
		return invoiceitemdetailDAO.getLatestInvoiceitemdetailID();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#getUserById(java.lang.String)
	 */
	@Override
	public Invoiceitemdetail getInvoiceitemdetailById(String invoiceitem) {
		return invoiceitemdetailDAO.getInvoiceitemdetailById(invoiceitem);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#listUsers()
	 */
	@Override
	public List<Invoiceitemdetail> listInvoiceitemdetail() {
		return invoiceitemdetailDAO.listInvoiceitemdetail();
	}

	@Override
	public List<Invoiceitemdetail> listInvoiceitemdetail(List<String> InvoiceitemdetailList) {
		// TODO Auto-generated method stub
		return invoiceitemdetailDAO.listInvoiceitemdetail(InvoiceitemdetailList);
	}
	@Override
	public List<Invoiceitemdetail> listInvoiceitemdetail(String id) {
		
		return invoiceitemdetailDAO.listInvoiceitemdetail(id);
	}

	@Override
	public List<Invoice> getInv() {
		// TODO Auto-generated method stub
		return invoiceitemdetailDAO.getInv();
	}
}

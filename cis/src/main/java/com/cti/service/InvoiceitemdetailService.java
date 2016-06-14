package com.cti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cti.model.Invoiceitemdetail;

@Transactional
public interface InvoiceitemdetailService {
	
public boolean saveInvoiceitemdetail(Invoiceitemdetail pur);
	
	public boolean updateInvoiceitemdetail(Invoiceitemdetail pur);
	
	public boolean removeInvoiceitemdetail(String purname);
	
	public Invoiceitemdetail getInvoiceitemdetailById(String purname);
	
	public String getLatestInvoiceitemdetailID();

	public List<Invoiceitemdetail> listInvoiceitemdetail();	
	
	public List<Invoiceitemdetail> listInvoiceitemdetail(List<String> InvoiceitemdetailList);
}

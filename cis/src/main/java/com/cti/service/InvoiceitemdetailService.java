package com.cti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cti.model.Invoice;
import com.cti.model.Invoiceitemdetail;

@Transactional
public interface InvoiceitemdetailService {
	
public boolean saveInvoiceitemdetail(Invoiceitemdetail invoiceitem);
	
	public boolean updateInvoiceitemdetail(Invoiceitemdetail invoiceitem);
	
	public boolean removeInvoiceitemdetail(String invoiceitem);
	
	public Invoiceitemdetail getInvoiceitemdetailById(String invoiceitem);
	
	public String getLatestInvoiceitemdetailID();

	public List<Invoiceitemdetail> listInvoiceitemdetail();
	
	public List<Invoiceitemdetail> listInvoiceitemdetail(String id);	

	public List<Invoice> getInv();	
	
	public List<Invoiceitemdetail> listInvoiceitemdetail(List<String> InvoiceitemdetailList);
}

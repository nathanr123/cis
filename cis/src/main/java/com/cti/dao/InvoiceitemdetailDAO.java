package com.cti.dao;

import java.util.List;

import com.cti.model.Invoiceitemdetail;

public interface InvoiceitemdetailDAO {
	
	public boolean saveInvoiceitemdetail(Invoiceitemdetail emp);
	
	public boolean updateInvoiceitemdetail(Invoiceitemdetail emp);
	
	public boolean removeInvoiceitemdetail(String empname);
	
	public Invoiceitemdetail getInvoiceitemdetailById(String empname);
	
	public String getLatestInvoiceitemdetailID();

	public List<Invoiceitemdetail> listInvoiceitemdetail();	
	
	public List<Invoiceitemdetail> listInvoiceitemdetail(List<String> InvoiceitemdetailList);
}

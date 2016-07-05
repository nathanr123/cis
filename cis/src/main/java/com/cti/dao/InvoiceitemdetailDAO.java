package com.cti.dao;

import java.util.List;

import com.cti.model.Invoice;
import com.cti.model.Invoiceitemdetail;

public interface InvoiceitemdetailDAO {
	
	public boolean saveInvoiceitemdetail(Invoiceitemdetail invoiceitem);
	
	public boolean updateInvoiceitemdetail(Invoiceitemdetail invoiceitem);
	
	public boolean removeInvoiceitemdetail(String invoiceitem);
	
	public Invoiceitemdetail getInvoiceitemdetailById(String invoiceitem);
	
	public String getLatestInvoiceitemdetailID();

	public List<Invoiceitemdetail> listInvoiceitemdetail();	
	
	public List<Invoice> getInv();	

	
	public List<Invoiceitemdetail> listInvoiceitemdetail(String id);	

	
	public List<Invoiceitemdetail> listInvoiceitemdetail(List<String> InvoiceitemdetailList);
}

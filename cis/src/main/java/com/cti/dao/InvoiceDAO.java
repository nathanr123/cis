package com.cti.dao;

import java.util.List;

import com.cti.model.Client;
import com.cti.model.Invoice;
import com.cti.model.Purchase;

public interface InvoiceDAO {
	
	public boolean saveInvoice(Invoice emp);
	
	public boolean updateInvoice(Invoice emp);
	
	public boolean removeInvoice(String empname);
	
	public Invoice getInvoiceById(String empname);
	
	public String getLatestInvoiceID();

	public List<Invoice> listInvoice();	
	
	public List<Client> getCust();
	
	public List<Purchase> getPur();
	
	public List<Invoice> listInvoice(List<String> InvoiceList);
}

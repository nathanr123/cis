package com.cti.dao;

import java.util.List;

import com.cti.model.Client;
import com.cti.model.Invoice;
import com.cti.model.Purchase;

public interface InvoiceDAO {
	
	public boolean saveInvoice(Invoice invoice);
	
	public boolean updateInvoice(Invoice invoice);
	
	public boolean removeInvoice(String invoice);
	
	public Invoice getInvoiceById(String invoice);
	
	public String getLatestInvoiceID();

	public List<Invoice> listInvoice();	
	
	public List<Client> getCust();
	
	public List<Purchase> getPur();
	
	public List<Invoice> listInvoice(List<String> InvoiceList);
}

package com.cti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cti.model.Client;
import com.cti.model.Invoice;
import com.cti.model.Purchase;

@Transactional
public interface InvoiceService {
	
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

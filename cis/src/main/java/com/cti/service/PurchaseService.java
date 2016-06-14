package com.cti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cti.model.Client;
import com.cti.model.Invoice;
import com.cti.model.Purchase;

@Transactional
public interface PurchaseService {
	
public boolean savePurchase(Purchase pur);
	
	public boolean updatePurchase(Purchase pur);
	
	public boolean removePurchase(String purname);
	
	public Purchase getPurchaseById(String purname);
	
	public String getLatestPurchaseID();

	public List<Purchase> listPurchase();	
	
	public   List<Client> getCust();
	
	public List<Purchase> listPurchase(List<String> PurchaseList);
}

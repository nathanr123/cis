package com.cti.dao;

import java.util.List;

import com.cti.model.Client;
import com.cti.model.Invoice;
import com.cti.model.Purchase;

public interface PurchaseDAO {
	
	public boolean savePurchase(Purchase emp);
	
	public boolean updatePurchase(Purchase emp);
	
	public boolean removePurchase(String empname);
	
	public Purchase getPurchaseById(String empname);
	
	public String getLatestPurchaseID();

	public List<Purchase> listPurchase();
	
	public List<Client> getCust();
	
	public List<Purchase> listPurchase(List<String> PurchaseList);
}

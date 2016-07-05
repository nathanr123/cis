package com.cti.dao;

import java.util.List;

import com.cti.model.Client;
import com.cti.model.Invoice;
import com.cti.model.Purchase;

public interface PurchaseDAO {
	
	public boolean savePurchase(Purchase purchase);
	
	public boolean updatePurchase(Purchase purchase);
	
	public boolean removePurchase(String purchase);
	
	public Purchase getPurchaseById(String purchase);
	
	public String getLatestPurchaseID();

	public List<Purchase> listPurchase();
	
	public List<Client> getCust();
	
	public List<Purchase> listPurchase(List<String> PurchaseList);
}

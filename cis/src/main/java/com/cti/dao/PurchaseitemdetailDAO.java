package com.cti.dao;

import java.util.List;

import com.cti.model.Purchaseitemdetail;

public interface PurchaseitemdetailDAO {
	
	public boolean savePurchaseitemdetail(Purchaseitemdetail purchaseitem);
	
	public boolean updatePurchaseitemdetail(Purchaseitemdetail purchaseitem);
	
	public boolean removePurchaseitemdetail(String purchaseitem);
	
	public Purchaseitemdetail getPurchaseitemdetailById(String purchaseitem);
	
	public String getLatestPurchaseitemdetailID();

	public List<Purchaseitemdetail> listPurchaseitemdetail();	

	public List<Purchaseitemdetail> listPurchaseitemdetail(String pur);	

	
	public List<Purchaseitemdetail> listPurchaseitemdetail(List<String> PurchaseitemdetailList);
}

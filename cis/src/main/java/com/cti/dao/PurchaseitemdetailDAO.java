package com.cti.dao;

import java.util.List;

import com.cti.model.Purchaseitemdetail;

public interface PurchaseitemdetailDAO {
	
	public boolean savePurchaseitemdetail(Purchaseitemdetail emp);
	
	public boolean updatePurchaseitemdetail(Purchaseitemdetail emp);
	
	public boolean removePurchaseitemdetail(String empname);
	
	public Purchaseitemdetail getPurchaseitemdetailById(String empname);
	
	public String getLatestPurchaseitemdetailID();

	public List<Purchaseitemdetail> listPurchaseitemdetail();	
	
	public List<Purchaseitemdetail> listPurchaseitemdetail(List<String> PurchaseitemdetailList);
}

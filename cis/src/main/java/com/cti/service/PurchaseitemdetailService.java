package com.cti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cti.model.Purchaseitemdetail;

@Transactional
public interface PurchaseitemdetailService {
	
public boolean savePurchaseitemdetail(Purchaseitemdetail pur);
	
	public boolean updatePurchaseitemdetail(Purchaseitemdetail pur);
	
	public boolean removePurchaseitemdetail(String purname);
	
	public Purchaseitemdetail getPurchaseitemdetailById(String purname);
	
	public String getLatestPurchaseitemdetailID();

	public List<Purchaseitemdetail> listPurchaseitemdetail();	
	
	public List<Purchaseitemdetail> listPurchaseitemdetail(String pur);	

	
	public List<Purchaseitemdetail> listPurchaseitemdetail(List<String> PurchaseitemdetailList);
}

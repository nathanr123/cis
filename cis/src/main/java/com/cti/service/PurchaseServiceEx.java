/**
 * 
 */
package com.cti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cti.dao.PurchaseDAO;
import com.cti.model.Client;
import com.cti.model.Invoice;
import com.cti.model.Purchase;

/**
 * @author nathanr_kamal
 *
 */
@Service
public class PurchaseServiceEx implements PurchaseService {

	@Autowired
	PurchaseDAO purchaseDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#saveUser(com.cti.model.User)
	 */
	@Override
	public boolean savePurchase(Purchase purchase) {
		return purchaseDAO.savePurchase(purchase);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#updateUser(com.cti.model.User)
	 */
	@Override
	public boolean updatePurchase(Purchase purchase) {
		return purchaseDAO.updatePurchase(purchase);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#removeUser(java.lang.String)
	 */
	@Override
	public boolean removePurchase(String purchase) {
		return purchaseDAO.removePurchase(purchase);
	}
	
	@Override
	public String getLatestPurchaseID() {
		return purchaseDAO.getLatestPurchaseID();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#getUserById(java.lang.String)
	 */
	@Override
	public Purchase getPurchaseById(String purchase) {
		return purchaseDAO.getPurchaseById(purchase);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#listUsers()
	 */
	@Override
	public List<Purchase> listPurchase() {
		return purchaseDAO.listPurchase();
	}

	@Override
	public List<Purchase> listPurchase(List<String> PurchaseList) {
		// TODO Auto-generated method stub
		return purchaseDAO.listPurchase(PurchaseList);
	}

	public List<Client> getCust() {
		// TODO Auto-generated method stub
		return purchaseDAO.getCust();
		
	}
}

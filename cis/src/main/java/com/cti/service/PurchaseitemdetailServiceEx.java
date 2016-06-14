/**
 * 
 */
package com.cti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cti.dao.PurchaseitemdetailDAO;
import com.cti.model.Purchaseitemdetail;

/**
 * @author nathanr_kamal
 *
 */
@Service
public class PurchaseitemdetailServiceEx implements PurchaseitemdetailService {

	@Autowired
	PurchaseitemdetailDAO PurchaseitemdetailDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#saveUser(com.cti.model.User)
	 */
	@Override
	public boolean savePurchaseitemdetail(Purchaseitemdetail it) {
		return PurchaseitemdetailDAO.savePurchaseitemdetail(it);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#updateUser(com.cti.model.User)
	 */
	@Override
	public boolean updatePurchaseitemdetail(Purchaseitemdetail it) {
		return PurchaseitemdetailDAO.updatePurchaseitemdetail(it);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#removeUser(java.lang.String)
	 */
	@Override
	public boolean removePurchaseitemdetail(String it) {
		return PurchaseitemdetailDAO.removePurchaseitemdetail(it);
	}
	
	@Override
	public String getLatestPurchaseitemdetailID() {
		return PurchaseitemdetailDAO.getLatestPurchaseitemdetailID();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#getUserById(java.lang.String)
	 */
	@Override
	public Purchaseitemdetail getPurchaseitemdetailById(String it) {
		return PurchaseitemdetailDAO.getPurchaseitemdetailById(it);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#listUsers()
	 */
	@Override
	public List<Purchaseitemdetail> listPurchaseitemdetail() {
		return PurchaseitemdetailDAO.listPurchaseitemdetail();
	}

	@Override
	public List<Purchaseitemdetail> listPurchaseitemdetail(List<String> PurchaseitemdetailList) {
		// TODO Auto-generated method stub
		return PurchaseitemdetailDAO.listPurchaseitemdetail(PurchaseitemdetailList);
	}

}

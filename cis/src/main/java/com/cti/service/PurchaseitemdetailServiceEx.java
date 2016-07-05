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
	public boolean savePurchaseitemdetail(Purchaseitemdetail purchaseitem) {
		return PurchaseitemdetailDAO.savePurchaseitemdetail(purchaseitem);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#updateUser(com.cti.model.User)
	 */
	@Override
	public boolean updatePurchaseitemdetail(Purchaseitemdetail purchaseitem) {
		return PurchaseitemdetailDAO.updatePurchaseitemdetail(purchaseitem);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#removeUser(java.lang.String)
	 */
	@Override
	public boolean removePurchaseitemdetail(String purchaseitem) {
		return PurchaseitemdetailDAO.removePurchaseitemdetail(purchaseitem);
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
	public Purchaseitemdetail getPurchaseitemdetailById(String purchaseitem) {
		return PurchaseitemdetailDAO.getPurchaseitemdetailById(purchaseitem);
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
	public List<Purchaseitemdetail> listPurchaseitemdetail(String pur) {
		return PurchaseitemdetailDAO.listPurchaseitemdetail(pur);
	}

	
	@Override
	public List<Purchaseitemdetail> listPurchaseitemdetail(List<String> PurchaseitemdetailList) {
		// TODO Auto-generated method stub
		return PurchaseitemdetailDAO.listPurchaseitemdetail(PurchaseitemdetailList);
	}

}

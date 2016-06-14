/**
 * 
 */
package com.cti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cti.dao.ItemsDAO;
import com.cti.model.Items;

/**
 * @author nathanr_kamal
 *
 */
@Service
public class ItemsServiceEx implements ItemsService {

	@Autowired
	ItemsDAO itemsDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#saveUser(com.cti.model.User)
	 */
	@Override
	public boolean saveItems(Items it) {
		return itemsDAO.saveItems(it);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#updateUser(com.cti.model.User)
	 */
	@Override
	public boolean updateItems(Items it) {
		return itemsDAO.updateItems(it);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#removeUser(java.lang.String)
	 */
	@Override
	public boolean removeItems(String it) {
		return itemsDAO.removeItems(it);
	}
	
	@Override
	public String getLatestItemsID() {
		return itemsDAO.getLatestItemsID();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#getUserById(java.lang.String)
	 */
	@Override
	public Items getItemsById(String it) {
		return itemsDAO.getItemsById(it);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#listUsers()
	 */
	@Override
	public List<Items> listItems() {
		return itemsDAO.listItems();
	}

	@Override
	public List<Items> listItems(List<String> itemsList) {
		// TODO Auto-generated method stub
		return itemsDAO.listItems(itemsList);
	}

}

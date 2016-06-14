package com.cti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cti.model.Items;

@Transactional
public interface ItemsService {
	
public boolean saveItems(Items it);
	
	public boolean updateItems(Items it);
	
	public boolean removeItems(String itname);
	
	public Items getItemsById(String itname);
	
	public String getLatestItemsID();

	public List<Items> listItems();	
	
	public List<Items> listItems(List<String> itemsList);
}

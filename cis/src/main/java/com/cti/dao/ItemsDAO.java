package com.cti.dao;

import java.util.List;

import com.cti.model.Items;

public interface ItemsDAO {
	
	public boolean saveItems(Items items);
	
	public boolean updateItems(Items items);
	
	public boolean removeItems(String items);
	
	public Items getItemsById(String items);
	
	public String getLatestItemsID();

	public List<Items> listItems();	
	
	public List<Items> listItems(List<String> itemsList);
}

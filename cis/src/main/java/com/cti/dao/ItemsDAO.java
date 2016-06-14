package com.cti.dao;

import java.util.List;

import com.cti.model.Items;

public interface ItemsDAO {
	
	public boolean saveItems(Items emp);
	
	public boolean updateItems(Items emp);
	
	public boolean removeItems(String empname);
	
	public Items getItemsById(String empname);
	
	public String getLatestItemsID();

	public List<Items> listItems();	
	
	public List<Items> listItems(List<String> itemsList);
}

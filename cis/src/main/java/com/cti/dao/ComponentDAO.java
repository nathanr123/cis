package com.cti.dao;

import java.util.List;

import com.cti.model.Component;

public interface ComponentDAO {
	
	public boolean saveComponent(Component component);
	
	public boolean updateComponent(Component component);
	
	public boolean removeComponent(String component);
	
	public Component getComponentById(String component);
	
	public String getLatestComponentID();

	public List<Component> listComponent();	
	
	public List<Component> listComponent(List<String> componentList);
}

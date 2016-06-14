package com.cti.dao;

import java.util.List;

import com.cti.model.Component;

public interface ComponentDAO {
	
	public boolean saveComponent(Component emp);
	
	public boolean updateComponent(Component emp);
	
	public boolean removeComponent(String empname);
	
	public Component getComponentById(String empname);
	
	public String getLatestComponentID();

	public List<Component> listComponent();	
	
	public List<Component> listComponent(List<String> componentList);
}

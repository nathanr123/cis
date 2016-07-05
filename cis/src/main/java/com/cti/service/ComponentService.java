package com.cti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cti.model.Component;

@Transactional
public interface ComponentService {
	
public boolean saveComponent(Component component);
	
	public boolean updateComponent(Component component);
	
	public boolean removeComponent(String component);
	
	public Component getComponentById(String component);
	
	public String getLatestComponentID();

	public List<Component> listComponent();	
	
	public List<Component> listComponent(List<String> componentList);
}

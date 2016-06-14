package com.cti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cti.model.Component;

@Transactional
public interface ComponentService {
	
public boolean saveComponent(Component it);
	
	public boolean updateComponent(Component it);
	
	public boolean removeComponent(String itname);
	
	public Component getComponentById(String itname);
	
	public String getLatestComponentID();

	public List<Component> listComponent();	
	
	public List<Component> listComponent(List<String> itemsList);
}

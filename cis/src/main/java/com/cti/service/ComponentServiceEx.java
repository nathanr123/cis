/**
 * 
 */
package com.cti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cti.dao.ComponentDAO;
import com.cti.model.Component;

/**
 * @author nathanr_kamal
 *
 */
@Service
public class ComponentServiceEx implements ComponentService {

	@Autowired
	ComponentDAO componentDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#saveUser(com.cti.model.User)
	 */
	@Override
	public boolean saveComponent(Component it) {
		return componentDAO.saveComponent(it);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#updateUser(com.cti.model.User)
	 */
	@Override
	public boolean updateComponent(Component it) {
		return componentDAO.updateComponent(it);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#removeUser(java.lang.String)
	 */
	@Override
	public boolean removeComponent(String it) {
		return componentDAO.removeComponent(it);
	}
	
	@Override
	public String getLatestComponentID() {
		return componentDAO.getLatestComponentID();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#getUserById(java.lang.String)
	 */
	@Override
	public Component getComponentById(String it) {
		return componentDAO.getComponentById(it);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#listUsers()
	 */
	@Override
	public List<Component> listComponent() {
		return componentDAO.listComponent();
	}

	@Override
	public List<Component> listComponent(List<String> componentList) {
		// TODO Auto-generated method stub
		return componentDAO.listComponent(componentList);
	}

}

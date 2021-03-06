/**
 * 
 */
package com.cti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cti.dao.ClientDAO;
import com.cti.model.Client;

/**
 * @author nathanr_kamal
 *
 */
@Service
public class ClientServiceEx implements ClientService {

	@Autowired
	ClientDAO clientDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#saveUser(com.cti.model.User)
	 */
	@Override
	public boolean saveClient(Client client) {
		return clientDAO.saveClient(client);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#updateUser(com.cti.model.User)
	 */
	@Override
	public boolean updateClient(Client client) {
		return clientDAO.updateClient(client);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#removeUser(java.lang.String)
	 */
	@Override
	public boolean removeClient(String client) {
		return clientDAO.removeClient(client);
	}
	
	@Override
	public String getLatestClientID() {
		return clientDAO.getLatestClientID();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#getUserById(java.lang.String)
	 */
	@Override
	public Client getClientById(String client) {
		return clientDAO.getClientById(client);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.service.UserService#listUsers()
	 */
	@Override
	public List<Client> listClient() {
		return clientDAO.listClient();
	}

	@Override
	public List<Client> listClient(List<String> ClientList) {
		// TODO Auto-generated method stub
		return clientDAO.listClient(ClientList);
	}

}

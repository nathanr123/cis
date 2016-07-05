package com.cti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cti.model.Client;

@Transactional
public interface ClientService {
	
public boolean saveClient(Client client);
	
	public boolean updateClient(Client client);
	
	public boolean removeClient(String client);
	
	public Client getClientById(String client);
	
	public String getLatestClientID();

	public List<Client> listClient();	
	
	public List<Client> listClient(List<String> clientList);
}

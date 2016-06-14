package com.cti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cti.model.Client;

@Transactional
public interface ClientService {
	
public boolean saveClient(Client it);
	
	public boolean updateClient(Client it);
	
	public boolean removeClient(String itname);
	
	public Client getClientById(String itname);
	
	public String getLatestClientID();

	public List<Client> listClient();	
	
	public List<Client> listClient(List<String> itemsList);
}

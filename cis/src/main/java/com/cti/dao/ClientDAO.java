package com.cti.dao;

import java.util.List;

import com.cti.model.Client;

public interface ClientDAO {
	
	public boolean saveClient(Client client);
	
	public boolean updateClient(Client client);
	
	public boolean removeClient(String clientname);
	
	public Client getClientById(String clientname);
	
	public String getLatestClientID();

	public List<Client> listClient();	
	
	public List<Client> listClient(List<String> ClientList);
}

package com.cti.dao;

import java.util.List;

import com.cti.model.Client;

public interface ClientDAO {
	
	public boolean saveClient(Client emp);
	
	public boolean updateClient(Client emp);
	
	public boolean removeClient(String empname);
	
	public Client getClientById(String empname);
	
	public String getLatestClientID();

	public List<Client> listClient();	
	
	public List<Client> listClient(List<String> ClientList);
}

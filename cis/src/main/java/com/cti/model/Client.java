package com.cti.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client implements Serializable {

	// Variables for corresponding to DB Table

	/**
	 * 
	 */

	private static final long serialVersionUID = -7189115628317969160L;

	private String client_ID;

	private String clientname;

	private String contactperson;
	
	private String department;
	
	private String address;

	private Date createdtime;

	private Date modifiedtime;

	public Client() {
	}

	public Client(String client_ID, String clientname, String contactperson, String department, String address,
			Date createdtime, Date modifiedtime) {
		
		this.client_ID = client_ID;
		this.clientname = clientname;
		this.contactperson = contactperson;
		this.department = department;
		this.address = address;
		this.createdtime = createdtime;
		this.modifiedtime = modifiedtime;
	}

	// Getter Method
	@Id
	@Column(name = "client_ID", nullable = false, unique = true, length = 35)
	public String getClient_ID() {
		return client_ID;
	}
	@Column(name = "clientname", nullable = false, length = 32)
	public String getClientname() {
		return clientname;
	}
	@Column(name = "contactperson", nullable = false, length = 32)
	public String getContactperson() {
		return contactperson;
	}
	@Column(name = "department", nullable = false, length = 32)
	public String getDepartment() {
		return department;
	}
	@Column(name = "address", nullable = false, length = 100)
	public String getAddress() {
		return address;
	}
	@Column(name = "createdtime", nullable = false)
	public Date getCreatedtime() {
		return createdtime;
	}
	@Column(name = "modifiedtime", nullable = false)
	public Date getModifiedtime() {
		return modifiedtime;
	}
	
	//Setter Methods

	public void setClient_ID(String client_ID) {
		this.client_ID = client_ID;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}

	public void setModifiedtime(Date modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

	



}

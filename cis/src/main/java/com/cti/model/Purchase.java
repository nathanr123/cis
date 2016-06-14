package com.cti.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchase")
public class Purchase implements Serializable {

	// Variables for corresponding to DB Table

	/**
	 * 
	 */

	private static final long serialVersionUID = -7189115628317969160L;

	private String purchase_ID;

	private String purchase_number;

	private String purchase_date;
	
	private String purchase_del_date;
	
	private String purchase_cust_name;

	private Date createdtime;

	private Date modifiedtime;

	public Purchase() {
	}

	public Purchase(String purchase_ID, String purchase_number, String purchase_date, String purchase_del_date,
			String purchase_cust_name, Date createdtime, Date modifiedtime) {
		
		this.purchase_ID = purchase_ID;
		this.purchase_number = purchase_number;
		this.purchase_date = purchase_date;
		this.purchase_del_date = purchase_del_date;
		this.purchase_cust_name = purchase_cust_name;
		this.createdtime = createdtime;
		this.modifiedtime = modifiedtime;
	}

	//Getter
	@Id
	@Column(name = "purchase_ID", nullable = false, unique = true, length = 10)
	public String getPurchase_ID() {
		return purchase_ID;
	}
	@Column(name = "purchase_number", nullable = false, length = 60)
	public String getPurchase_number() {
		return purchase_number;
	}
	@Column(name = "purchase_date", nullable = false, length = 12)
	public String getPurchase_date() {
		return purchase_date;
	}
	@Column(name = "purchase_del_date", nullable = false, length = 12)
	public String getPurchase_del_date() {
		return purchase_del_date;
	}
	@Column(name = "purchase_cust_name", nullable = false, length = 50)
	public String getPurchase_cust_name() {
		return purchase_cust_name;
	}
	@Column(name = "createdtime", nullable = false)
	public Date getCreatedtime() {
		return createdtime;
	}
	@Column(name = "modifiedtime", nullable = false)
	public Date getModifiedtime() {
		return modifiedtime;
	}


	//Setter
	public void setPurchase_ID(String purchase_ID) {
		this.purchase_ID = purchase_ID;
	}

	public void setPurchase_number(String purchase_number) {
		this.purchase_number = purchase_number;
	}

	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}

	public void setPurchase_del_date(String purchase_del_date) {
		this.purchase_del_date = purchase_del_date;
	}

	public void setPurchase_cust_name(String purchase_cust_name) {
		this.purchase_cust_name = purchase_cust_name;
	}

	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}

	public void setModifiedtime(Date modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

	
	
	
}

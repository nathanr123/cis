package com.cti.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice implements Serializable {

	// Variables for corresponding to DB Table

	/**
	 * 
	 */
	
	

	private static final long serialVersionUID = -7189115628317969160L;

	private String invoice_ID;

	private String invoice_number;

	private Date invoice_date;
	
	
	
	private String warrenty_term;
	
	private Date warrenty_date;
	
	private Date expairy_date;
	
	private String custname;
	
	private String del_chalan_number;
	
	private String po_number;

	private Date createdtime;

	private Date modifiedtime;

	public Invoice() {
	}

	public Invoice(String invoice_ID, String invoice_number, Date invoice_date, String warrenty_term,
			Date warrenty_date, Date expairy_date, String custname, String del_chalan_number, String po_number,
			Date createdtime, Date modifiedtime) {
		
		
		this.invoice_ID = invoice_ID;
		this.invoice_number = invoice_number;
		this.invoice_date = invoice_date;
		this.warrenty_term = warrenty_term;
		this.warrenty_date = warrenty_date;
		this.expairy_date = expairy_date;
		this.custname = custname;
		this.del_chalan_number = del_chalan_number;
		this.po_number = po_number;
		this.createdtime = createdtime;
		this.modifiedtime = modifiedtime;
	}

	
	//Getter
	@Id
	@Column(name = "invoice_ID", nullable = false, unique = true, length = 10)
	public String getInvoice_ID() {
		return invoice_ID;
	}
	@Column(name = "invoice_number", nullable = false, length = 60)
	public String getInvoice_number() {
		return invoice_number;
	}
	@Column(name = "invoice_date", nullable = false)
	public Date getInvoice_date() {
		return invoice_date;
	}
	@Column(name = "warrenty_term", nullable = false, length = 10)
	public String getWarrenty_term() {
		return warrenty_term;
	}
	@Column(name = "warrenty_date", nullable = false)
	public Date getWarrenty_date() {
		return warrenty_date;
	}
	@Column(name = "expairy_date", nullable = false)
	public Date getExpairy_date() {
		return expairy_date;
	}
	@Column(name = "custname", nullable = false, length = 50)
	public String getCustname() {
		return custname;
	}
	@Column(name = "del_chalan_number", nullable = false, length = 50)
	public String getDel_chalan_number() {
		return del_chalan_number;
	}
	@Column(name = "po_number", nullable = false, length = 50)
	public String getPo_number() {
		return po_number;
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

	public void setInvoice_ID(String invoice_ID) {
		this.invoice_ID = invoice_ID;
	}

	public void setInvoice_number(String invoice_number) {
		this.invoice_number = invoice_number;
	}

	public void setInvoice_date(Date invoice_date) {
		this.invoice_date = invoice_date;
	}

	public void setWarrenty_term(String warrenty_term) {
		this.warrenty_term = warrenty_term;
	}

	public void setWarrenty_date(Date warrenty_date) {
		this.warrenty_date = warrenty_date;
	}

	public void setExpairy_date(Date expairy_date) {
		this.expairy_date = expairy_date;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public void setDel_chalan_number(String del_chalan_number) {
		this.del_chalan_number = del_chalan_number;
	}

	public void setPo_number(String po_number) {
		this.po_number = po_number;
	}

	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}

	public void setModifiedtime(Date modifiedtime) {
		this.modifiedtime = modifiedtime;
	}
	
	
	
	
	
}

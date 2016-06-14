package com.cti.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchaseitemdetail")
public class Purchaseitemdetail implements Serializable {

	// Variables for corresponding to DB Table

	/**
	 * 
	 */

	private static final long serialVersionUID = -7189115628317969160L;

	private String product_ID;

	private String purchasenumber;

	private String qty;
	
	private String unitrate;
	
	private String tax;
	
	private String taxamount;
	
	private String totalprice;
	
	private String totalpricetax;

	private Date createdtime;

	private Date modifiedtime;

	public Purchaseitemdetail() {
	}

	public Purchaseitemdetail(String product_ID, String purchasenumber, String qty, String unitrate, String tax,
			String taxamount, String totalprice, String totalpricetax, Date createdtime, Date modifiedtime) {
		
		this.product_ID = product_ID;
		this.purchasenumber = purchasenumber;
		this.qty = qty;
		this.unitrate = unitrate;
		this.tax = tax;
		this.taxamount = taxamount;
		this.totalprice = totalprice;
		this.totalpricetax = totalpricetax;
		this.createdtime = createdtime;
		this.modifiedtime = modifiedtime;
	}

	//Getter
	@Id
	@Column(name = "product_ID", nullable = false, unique = true, length = 32)
	public String getProduct_ID() {
		return product_ID;
	}
	@Column(name = "purchasenumber", nullable = false, length = 50)
	public String getPurchasenumber() {
		return purchasenumber;
	}
	@Column(name = "qty", nullable = false, length = 35)
	public String getQty() {
		return qty;
	}
	@Column(name = "unitrate", nullable = false, length = 250)
	public String getUnitrate() {
		return unitrate;
	}
	@Column(name = "tax", nullable = false, length = 100)
	public String getTax() {
		return tax;
	}
	@Column(name = "taxamount", nullable = false, length = 100)
	public String getTaxamount() {
		return taxamount;
	}
	@Column(name = "totalprice", nullable = false, length = 50)
	public String getTotalprice() {
		return totalprice;
	}
	@Column(name = "totalpricetax", nullable = false, length = 50)
	public String getTotalpricetax() {
		return totalpricetax;
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
	public void setProduct_ID(String product_ID) {
		this.product_ID = product_ID;
	}

	public void setPurchasenumber(String purchasenumber) {
		this.purchasenumber = purchasenumber;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public void setUnitrate(String unitrate) {
		this.unitrate = unitrate;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public void setTaxamount(String taxamount) {
		this.taxamount = taxamount;
	}

	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}

	public void setTotalpricetax(String totalpricetax) {
		this.totalpricetax = totalpricetax;
	}

	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}

	public void setModifiedtime(Date modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

	
	
	
}

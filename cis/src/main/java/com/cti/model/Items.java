package com.cti.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Items implements Serializable {

	// Variables for corresponding to DB Table

	/**
	 * 
	 */

	private static final long serialVersionUID = -7189115628317969160L;

	private String product_ID;

	private String part_number;

	private String description;

	private Date createdtime;

	private Date modifiedtime;

	public Items() {
	}

	public Items(String product_ID, String part_number, String description, Date createdtime, Date modifiedtime) {
		super();
		this.product_ID = product_ID;
		this.part_number = part_number;
		this.description = description;
		this.createdtime = createdtime;
		this.modifiedtime = modifiedtime;
	}

	// Getter Methods
	@Id
	@Column(name = "product_ID", nullable = false, unique = true, length = 30)
	public String getProduct_ID() {
		return product_ID;
	}
	@Column(name = "part_number", nullable = false, length = 50)
	public String getPart_number() {
		return part_number;
	}
	@Column(name = "description", nullable = false,length = 100)
	public String getDescription() {
		return description;
	}
	@Column(name = "createdtime", nullable = false)
	public Date getCreatedtime() {
		return createdtime;
	}
	@Column(name = "modifiedtime", nullable = false)
	public Date getModifiedtime() {
		return modifiedtime;
	}

	// Setter Methods
	public void setProduct_ID(String product_ID) {
		this.product_ID = product_ID;
	}

	public void setPart_number(String part_number) {
		this.part_number = part_number;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}

	public void setModifiedtime(Date modifiedtime) {
		this.modifiedtime = modifiedtime;
	}
}

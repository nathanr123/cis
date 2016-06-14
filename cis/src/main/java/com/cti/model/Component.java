package com.cti.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "component")
public class Component implements Serializable {

	// Variables for corresponding to DB Table

	/**
	 * 
	 */

	private static final long serialVersionUID = -7189115628317969160L;

	private String comp_ID;

	private String ctipartno;

	private String ctiuspartno;
	
	private String type;
	
	private String manufacturer;
	
	private String mfgpartno;
	
	private String mfgdesc;
	
	private String packages;

	private Date createdtime;

	private Date modifiedtime;

	public Component() {
	}

	public Component(String comp_ID, String ctipartno, String ctiuspartno, String type, String manufacturer,
			String mfgpartno, String mfgdesc, String packages, Date createdtime, Date modifiedtime) {
		
		this.comp_ID = comp_ID;
		this.ctipartno = ctipartno;
		this.ctiuspartno = ctiuspartno;
		this.type = type;
		this.manufacturer = manufacturer;
		this.mfgpartno = mfgpartno;
		this.mfgdesc = mfgdesc;
		this.packages = packages;
		this.createdtime = createdtime;
		this.modifiedtime = modifiedtime;
	}

	// Getter Methods
	@Id
	@Column(name = "comp_ID", nullable = false, unique = true, length = 10)
	public String getComp_ID() {
		return comp_ID;
	}
	@Column(name = "ctipartno", nullable = false, length = 150)
	public String getCtipartno() {
		return ctipartno;
	}
	@Column(name = "ctiuspartno", nullable = false, length = 150)
	public String getCtiuspartno() {
		return ctiuspartno;
	}
	@Column(name = "type", nullable = false, length = 50)
	public String getType() {
		return type;
	}
	@Column(name = "manufacturer", nullable = false, length = 150)
	public String getManufacturer() {
		return manufacturer;
	}
	@Column(name = "mfgpartno", nullable = false, length = 150)
	public String getMfgpartno() {
		return mfgpartno;
	}
	@Column(name = "mfgdesc", nullable = false, length = 250)
	public String getMfgdesc() {
		return mfgdesc;
	}
	@Column(name = "package", nullable = false, length = 100)
	public String getPackages() {
		return packages;
	}

	public Date getCreatedtime() {
		return createdtime;
	}

	public Date getModifiedtime() {
		return modifiedtime;
	}
	

	//Setter Methods

	public void setComp_ID(String comp_ID) {
		this.comp_ID = comp_ID;
	}

	public void setCtipartno(String ctipartno) {
		this.ctipartno = ctipartno;
	}

	public void setCtiuspartno(String ctiuspartno) {
		this.ctiuspartno = ctiuspartno;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setMfgpartno(String mfgpartno) {
		this.mfgpartno = mfgpartno;
	}

	public void setMfgdesc(String mfgdesc) {
		this.mfgdesc = mfgdesc;
	}

	public void setPackages(String packages) {
		this.packages = packages;
	}

	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}

	public void setModifiedtime(Date modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

	

	
	
	
}
package com.cti.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	// Variables for corresponding to DB Table

	/**
	 * 
	 */

	private static final long serialVersionUID = -7189115628317969160L;
	
	private String empid;

	private String empname;

	private int empage;
	
	private String empnumber;

	private String empgender;

	private Date empdob;
	
	private String empaddr;
	
	private String empcommaddr;
	
	private String empmobileno;

	private Date createdtime;

	private Date modifiedtime;

	// Constructors

	/**
	 * 
	 */
	public Employee() {
	}

	public Employee(String empid, String empname, String empnumber, int empage, String empgender,Date empdob, String empaddr, String empcommaddr, String empmobileno, Date createdtime, Date modifiedtime) {

		this.empid = empid;
		
		this.empname = empname;
		
		this.empage = empage;
		
		this.empnumber = empnumber;
		
		this.empgender = empgender;
		
		this.empdob = empdob;
		
		this.empaddr = empaddr;
		
		this.empcommaddr = empcommaddr;
		
		this.empmobileno = empmobileno;

		this.createdtime = createdtime;

		this.modifiedtime = modifiedtime;
	}

	// Getter Methods

	/**
	 * @return the empid
	 */
	@Id
	@Column(name = "empid", nullable = false, unique = true, length = 10)
	public String getEmpid() {
		return empid;
	}

	/**
	 * @return the empname
	 */
	@Column(name = "empname", nullable = false, length = 35)
	public String getEmpname() {
		return empname;
	}
	
	
	/**
	 * @return the empnumber
	 */
	@Column(name = "empnumber", nullable = false, length = 10)
	public String getEmpnumber() {
		return empnumber;
	}

	
	
	/**
	 * @return the empage
	 */
	@Column(name = "empage", nullable = false, length = 3)
	public int getEmpage() {
		return empage;
	}
	/**
	 * @return the empgender
	 */
	@Column(name = "empgender", nullable = false, length = 6)
	public String getEmpgender() {
		return empgender;
	}
	/**
	 * @return the empdob
	 */
	@Column(name = "empdob", nullable = false)
	public Date getEmpdob() {
		return empdob;
	}
	/**
	 * @return the empaddr
	 */
	@Column(name = "empaddress", nullable = false, length = 250)
	public String getEmpaddr() {
		return empaddr;
	}
	/**
	 * @return the empcommaddr
	 */
	@Column(name = "empcommaddress", nullable = false, length = 250)
	public String getEmpcommaddr() {
		return empcommaddr;
	}
	/**
	 * @return the empmobileno
	 */
	@Column(name = "empmobileno", nullable = false, length = 10)
	public String getEmpmobileno() {
		return empmobileno;
	}

	/**
	 * @return the createdtime
	 */
	@Column(name = "createdtime", nullable = false)
	public Date getCreatedtime() {
		return createdtime;
	}

	/**
	 * @return the modifiedtime
	 */
	@Column(name = "modifiedtime", nullable = false)
	public Date getModifiedtime() {
		return modifiedtime;
	}

	// Setter Methods

	/**
	 * @param empid
	 *            the empid to set
	 */
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	/**
	 * @param empname
	 *            the empname to set
	 */
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	
	
	/**
	 * @param empnumber
	 *            the empnumber to set
	 */
	public void setEmpnumber(String empname) {
		this.empnumber = empname;
	}
	
	
	/**
	 * @param empage
	 *            the empage to set
	 */
	public void setEmpage(int empage) {
		this.empage = empage;
	}
	/**
	 * @param empgender
	 *            the empgender to set
	 */
	public void setEmpgender(String empgender) {
		this.empgender = empgender;
	}
	/**
	 * @param empdob
	 *            the empdob to set
	 */
	public void setEmpdob(Date empdob) {
		this.empdob = empdob;
	}
	/**
	 * @param empaddr
	 *            the empaddr to set
	 */
	public void setEmpaddr(String empaddr) {
		this.empaddr = empaddr;
	}
	/**
	 * @param empcomaddr
	 *            the empcommaddr to set
	 */
	public void setEmpcommaddr(String empcommaddr) {
		this.empcommaddr = empcommaddr;
	}
	/**
	 * @param empmobileno
	 *            the empmobileno to set
	 */
	public void setEmpmobileno(String empmobileno) {
		this.empmobileno = empmobileno;
	}

	/**
	 * @param createdtime
	 *            the createdtime to set
	 */
	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}

	/**
	 * @param modifiedtime
	 *            the modifiedtime to set
	 */
	public void setModifiedtime(Date modifiedtime) {
		this.modifiedtime = modifiedtime;
	}


}

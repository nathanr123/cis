package com.cti.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
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
@Table(name = "rems_user")
public class User implements Serializable {

	// Variables for corresponding to DB Table

	/**
	 * 
	 */

	private static final long serialVersionUID = -7189115628317969160L;

	private String username;

	private String password;

	private String confirmPassword;

	private int priority = -1;

	private String userrole;

	private boolean enabled = true;

	private boolean accountNonExpired = true;

	private boolean accountNonLocked = true;

	private boolean credentialsNonExpired = true;

	private Date createdtime;

	private Date modifiedtime;

	private Set<UserGroup> groups = new HashSet<UserGroup>();

	private UserDetail userDetail;

	private UserAttempts userAttempts;

	// Constructors

	/**
	 * 
	 */
	public User() {
	}

	public User(String username, String password, int priority,
			String userrole, boolean enabled, boolean accountNonExpired,
			boolean accountNonLocked, boolean credentialsNonExpired,
			Date createdtime, Date modifiedtime) {

		this.username = username;

		this.password = password;

		this.priority = priority;

		this.userrole = userrole;

		this.enabled = enabled;

		this.accountNonExpired = accountNonExpired;

		this.accountNonLocked = accountNonLocked;

		this.credentialsNonExpired = credentialsNonExpired;

		this.createdtime = createdtime;

		this.modifiedtime = modifiedtime;
	}

	// Getter Methods

	/**
	 * @return the username
	 */
	@Id
	@Column(name = "username", nullable = false, unique = true, length = 16)
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	@Column(name = "password", nullable = false, length = 250)
	public String getPassword() {
		return password;
	}

	/**
	 * @return the priority
	 */
	@Column(name = "priority", nullable = false)
	public int getPriority() {
		return priority;
	}

	/**
	 * @return the userrole
	 */
	@Column(name = "userrole", nullable = false)
	public String getUserrole() {
		return userrole;
	}

	/**
	 * @return the enabled
	 */
	@Column(name = "enabled", nullable = false)
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @return the accountNonExpired
	 */
	@Column(name = "accountNonExpired", nullable = false)
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	/**
	 * @return the accountNonLocked
	 */
	@Column(name = "accountNonLocked", nullable = false)
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	/**
	 * @return the credentialsNonExpired
	 */
	@Column(name = "credentialsNonExpired", nullable = false)
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
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
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param priority
	 *            the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * @param userrole
	 *            the userrole to set
	 */
	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	/**
	 * @param enabled
	 *            the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @param accountNonExpired
	 *            the accountNonExpired to set
	 */
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	/**
	 * @param accountNonLocked
	 *            the accountNonLocked to set
	 */
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	/**
	 * @param credentialsNonExpired
	 *            the credentialsNonExpired to set
	 */
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
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

	/**
	 * @return the confirmPassword
	 */
	@Transient
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword
	 *            the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * @return the groups
	 */
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.ALL)
	// Users List Variable name in UserGroup "users"
	public Set<UserGroup> getGroups() {
		return groups;
	}

	/**
	 * @param groups
	 *            the groups to set
	 */
	public void setGroups(Set<UserGroup> groups) {
		this.groups = groups;
	}

	/**
	 * @return the userDetail
	 */
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	// Users List Variable name in UserDetail "user"
	public UserDetail getUserDetail() {
		return userDetail;
	}

	/**
	 * @param userDetail
	 *            the userDetail to set
	 */
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	/**
	 * @return the userAttempts
	 */
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "userAttempted", cascade = CascadeType.ALL)
	// Users List Variable name in UserAttempts "userAttempted"
	public UserAttempts getUserAttempts() {
		return userAttempts;
	}

	/**
	 * @param userAttempts
	 *            the userAttempts to set
	 */
	public void setUserAttempts(UserAttempts userAttempts) {
		this.userAttempts = userAttempts;
	}

	public void addGroupToUser(UserGroup usrGRP) {
		this.groups.add(usrGRP);
	}

}

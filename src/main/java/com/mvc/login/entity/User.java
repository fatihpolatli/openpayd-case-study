package com.mvc.login.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique = true)
	private String username;

	@JsonIgnore
	private String password;

	private String firstName;

	private String lastName;

	private String email;

	private String enabled = "true";

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Set<UserAccount> accounts = new HashSet<UserAccount>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "primary_address_id")
	private Address primaryAddress;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "secondary_address_id")
	private Address secondaryAddress;

	
	/** 
	 * @return Long
	 */
	public Long getId() {
		return id;
	}

	
	/** 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	
	/** 
	 * @return Set<UserAccount>
	 */
	public Set<UserAccount> getAccounts() {
		return accounts;
	}

	
	/** 
	 * @param accounts
	 */
	public void setAccounts(Set<UserAccount> accounts) {
		this.accounts = accounts;
	}

	
	/** 
	 * @return String
	 */
	public String getUsername() {
		return username;
	}

	
	/** 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	
	/** 
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	
	/** 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	/** 
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	
	/** 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	
	/** 
	 * @return String
	 */
	public String getEnabled() {
		return enabled;
	}

	
	/** 
	 * @param enabled
	 */
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	
	/** 
	 * @return Address
	 */
	public Address getPrimaryAddress() {
		return primaryAddress;
	}

	
	/** 
	 * @param primaryAddress
	 */
	public void setPrimaryAddress(Address primaryAddress) {
		this.primaryAddress = primaryAddress;
	}

	
	/** 
	 * @return Address
	 */
	public Address getSecondaryAddress() {
		return secondaryAddress;
	}

	
	/** 
	 * @param secondaryAddress
	 */
	public void setSecondaryAddress(Address secondaryAddress) {
		this.secondaryAddress = secondaryAddress;
	}

	
	/** 
	 * @return String
	 */
	public String getFirstName() {
		return firstName;
	}

	
	/** 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	/** 
	 * @return String
	 */
	public String getLastName() {
		return lastName;
	}

	
	/** 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	/** 
	 * @param id
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param enabled
	 * @param accounts
	 * @param primaryAddress
	 * @param secondaryAddress
	 * @return 
	 */
	public User(Long id, String username, String password, String firstName, String lastName, String email,
			String enabled, Set<UserAccount> accounts, Address primaryAddress, Address secondaryAddress) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.enabled = enabled;
		this.accounts = accounts;
		this.primaryAddress = primaryAddress;
		this.secondaryAddress = secondaryAddress;
	}

	
	/** 
	 * @return 
	 */
	public User() {
	}

}
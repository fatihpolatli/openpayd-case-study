package com.mvc.login.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT_HISTORY")
public class AccountHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "account_id")
	private UserAccount account;

	private Long actionDate = System.currentTimeMillis();

	private Long amount;

	private Integer type;

	
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
	 * @return UserAccount
	 */
	public UserAccount getAccount() {
		return account;
	}

	
	/** 
	 * @param account
	 */
	public void setAccount(UserAccount account) {
		this.account = account;
	}

	
	/** 
	 * @return Long
	 */
	public Long getAmount() {
		return amount;
	}

	
	/** 
	 * @param amount
	 */
	public void setAmount(Long amount) {
		this.amount = amount;
	}

	
	/** 
	 * @return Integer
	 */
	public Integer getType() {
		return type;
	}

	
	/** 
	 * @param type
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	
	/** 
	 * @return Long
	 */
	public Long getActionDate() {
		return actionDate;
	}

	
	/** 
	 * @param actionDate
	 */
	public void setActionDate(Long actionDate) {
		this.actionDate = actionDate;
	}

}

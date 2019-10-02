package com.mvc.login.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mvc.login.enums.AccountTypeEnum;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "USER_ACCOUNT")
@Where(clause = "is_deleted = 0")
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long balance = 0L;

	@Enumerated(EnumType.STRING)
	private AccountTypeEnum accountType;

	@Column(name = "user_id")
	private Long userId;

	private Integer isDeleted = 0;

	
	/** 
	 * @return Integer
	 */
	public Integer getIsDeleted() {
		return isDeleted;
	}

	
	/** 
	 * @param isDeleted
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	
	/** 
	 * @return Long
	 */
	public Long getUserId() {
		return userId;
	}

	
	/** 
	 * @param userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
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
	 * @return Long
	 */
	public Long getBalance() {
		return balance;
	}

	
	/** 
	 * @param balance
	 */
	public void setBalance(Long balance) {
		this.balance = balance;
	}

	
	/** 
	 * @return AccountTypeEnum
	 */
	public AccountTypeEnum getAccountType() {
		return accountType;
	}

	
	/** 
	 * @param accountType
	 */
	public void setAccountType(AccountTypeEnum accountType) {
		this.accountType = accountType;
	}

}

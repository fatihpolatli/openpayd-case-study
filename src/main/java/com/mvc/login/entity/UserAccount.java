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

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public AccountTypeEnum getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountTypeEnum accountType) {
		this.accountType = accountType;
	}

}

package com.mvc.login.dto;

import com.mvc.login.entity.UserAccount;
import com.mvc.login.entity.User;

public class TransferDto{

	private User targetUser;
	
	private UserAccount targetAccount;
	
	private BalanceDto balance;

	public User getTargetUser() {
		return targetUser;
	}

	public void setTargetUser(User targetUser) {
		this.targetUser = targetUser;
	}

	public BalanceDto getBalance() {
		return balance;
	}

	public void setBalance(BalanceDto balance) {
		this.balance = balance;
	}

	public UserAccount getTargetAccount() {
		return targetAccount;
	}

	public void setTargetAccount(UserAccount targetAccount) {
		this.targetAccount = targetAccount;
	}
}

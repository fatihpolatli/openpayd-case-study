package com.mvc.login.service.impl;

import javax.transaction.Transactional;

import com.mvc.login.dao.IUserDao;
import com.mvc.login.dto.BalanceDto;
import com.mvc.login.dto.TransferDto;
import com.mvc.login.entity.User;
import com.mvc.login.enums.AccountTransactionType;
import com.mvc.login.service.IMoneyTransferService;
import com.mvc.login.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MoneyTransferService
 */
@Service
public class MoneyTransferService implements IMoneyTransferService {


    @Autowired
    private IUserDao userDao;
    
    @Autowired
    private IUserService userService;

    @Override
	@Transactional
	public synchronized Boolean transferMoney(TransferDto transferData) throws Exception {

		User targetUser = userDao.findByUsername(transferData.getTargetUser().getUsername());

		BalanceDto balanceData = transferData.getBalance();

		balanceData.setType(AccountTransactionType.SUBTRACT);

		userService.addSubtractBalance(balanceData);

		balanceData.setType(AccountTransactionType.ADD);

		balanceData.setAccount(transferData.getTargetAccount());

		userService.addSubtractBalanceByUser(targetUser, balanceData);

		return true;
	}
}
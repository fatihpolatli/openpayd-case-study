package com.mvc.login.service;

import com.mvc.login.dto.TransferDto;

/**
 * IMoneyTransferService
 */
public interface IMoneyTransferService {

	Boolean  transferMoney(TransferDto transferData) throws Exception;
}
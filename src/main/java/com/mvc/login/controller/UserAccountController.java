package com.mvc.login.controller;

import com.mvc.login.dto.BalanceDto;
import com.mvc.login.dto.TransferDto;
import com.mvc.login.enums.AccountTypeEnum;
import com.mvc.login.exception.NoUserException;
import com.mvc.login.service.IUserService;
import com.mvc.login.util.GenericResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/restful/accounts")
public class UserAccountController {

	@Autowired
	IUserService userService;

	/**
	 * add new bank account for user
	 * 
	 * @param accountType type of account CR or DR
	 */
	@GetMapping(value = "/add/account-types/{accountType}")
	public GenericResponse addUserAccount(@PathVariable AccountTypeEnum accountType) throws Exception {

		return new GenericResponse(null, null, userService.addAcount(accountType));

	}

	/**
	 * delete bank account of user
	 * 
	 * @param accountType type of account CR or DR
	 */
	@GetMapping(value = "/delete/{accountType}")
	public GenericResponse deleteUserAccount(@PathVariable AccountTypeEnum accountType) throws Exception {

		userService.deleteAccount(accountType);
		return new GenericResponse(null, null, true);

	}

	/**
	 * list accounts of user
	 * 
	 */
	@GetMapping
	public GenericResponse getUserAccounts() throws NoUserException {

		return new GenericResponse(null, null, userService.getAccounts());

	}

	/**
	 * get defined account of user
	 * 
	 * @param accountType type of account CR or DR
	 */
	@GetMapping("{accountType}")
	public GenericResponse getUserAccountById(@PathVariable AccountTypeEnum accountType) throws NoUserException {

		return new GenericResponse(null, null, userService.getAccountByType(accountType));

	}

	/**
	 * cash or refill account
	 * 
	 * @param balance balance data
	 */
	@PostMapping(value = "/balance")
	public GenericResponse addBalance(@RequestBody BalanceDto balance) throws Exception {

		return new GenericResponse(null, null, userService.addSubtractBalance(balance));

	}

	/**
	 * get current balance of the account
	 * 
	 * @param accountType type of account CR or DR
	 */
	@GetMapping(value = "/current-balance/account-types/{accountType}")
	public GenericResponse getCurrentBalance(@PathVariable AccountTypeEnum accountType) throws Exception {

		return new GenericResponse(null, null, userService.getCurrentBalance(accountType));

	}

	/**
	 * get transaction history of the account
	 * 
	 * @param accountType type of account CR or DR
	 */
	@GetMapping(value = "/history/account-types/{accountType}")
	public GenericResponse getAccountHistory(@PathVariable AccountTypeEnum accountType) throws Exception {

		return new GenericResponse(null, null, userService.getAccountHistory(accountType));

	}

	/**
	 * load balance to the account from external source
	 * 
	 * @param balance balance data
	 */
	@PostMapping(value = "/load-balance")
	public GenericResponse loadBalance(@RequestBody BalanceDto balance) throws Exception {

		return new GenericResponse(null, null, userService.loadBalance(balance));

	}

}
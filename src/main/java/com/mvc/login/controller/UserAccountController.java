package com.mvc.login.controller;

import com.mvc.login.dto.BalanceDto;
import com.mvc.login.dto.TransferDto;
import com.mvc.login.enums.AccountTypeEnum;
import com.mvc.login.service.IUserService;
import com.mvc.login.util.GenericResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/restful/accounts")
public class UserAccountController {

	@Autowired
	IUserService userService;

	@GetMapping(value = "/add/account-types/{accountType}")
	public GenericResponse addUserAccount(@RequestParam AccountTypeEnum accountType){

		try {
			return new GenericResponse(null, null, userService.addAcount(accountType));
		} catch (Exception e) {
			return new GenericResponse(e.getMessage(), "error");
		}

	}

	@GetMapping(value = "/delete/{accountType}")
	public GenericResponse deleteUserAccount(@RequestParam AccountTypeEnum accountType) {

		try {
			userService.deleteAccount(accountType);
			return new GenericResponse(null, null, true);
		} catch (Exception e) {
			return new GenericResponse(e.getMessage(), "error");
		}

	}

	@GetMapping(value = "/list")
	public GenericResponse getUserAccounts() {

		System.out.println("NAME");
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());

		try {

			return new GenericResponse(null, null, userService.getAccounts());
		} catch (Exception e) {
			return new GenericResponse(e.getMessage(), "error");
		}

	}

	@PostMapping(value = "/balance")
	public GenericResponse addBalance(@RequestBody BalanceDto balance) {

		try {

			return new GenericResponse(null, null, userService.addSubtractBalance(balance));
		} catch (Exception e) {
			return new GenericResponse(e.getMessage(), "error");
		}

	}

	@GetMapping(value = "/current-balance/account-types/{accountType}")
	public GenericResponse getCurrentBalance(@RequestParam AccountTypeEnum accountType) {

		try {

			return new GenericResponse(null, null, userService.getCurrentBalance(accountType));
		} catch (Exception e) {
			return new GenericResponse(e.getMessage(), "error");
		}

	}

	@GetMapping(value = "/history/account-types/{accountType}")
	public GenericResponse getAccountHistory(@RequestParam AccountTypeEnum accountType) {

		try {

			return new GenericResponse(null, null, userService.getAccountHistory(accountType));
		} catch (Exception e) {
			return new GenericResponse(e.getMessage(), "error");
		}

	}

	@PostMapping(value = "/transfer")
	public GenericResponse transferMoney(@RequestBody TransferDto transferData) {

		try {

			return new GenericResponse(null, null, userService.transferMoney(transferData));
		} catch (Exception e) {
			return new GenericResponse(e.getMessage(), "error");
		}

	}

	@PostMapping(value = "/loadBalance")
	public GenericResponse loadBalance(@RequestBody BalanceDto balance) {

		try {

			return new GenericResponse(null, null, userService.loadBalance(balance));
		} catch (Exception e) {
			return new GenericResponse(e.getMessage(), "error");
		}

	}

}
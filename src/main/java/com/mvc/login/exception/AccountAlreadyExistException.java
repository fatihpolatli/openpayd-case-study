package com.mvc.login.exception;

public class AccountAlreadyExistException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4269529182141276748L;

	private int code = 2001;

	
	/** 
	 * @return 
	 */
	public AccountAlreadyExistException() {

		super("there is already an account with this currency");
	}

	
	/** 
	 * @return int
	 */
	@Override
	public int getCode() {
		return this.code;
	}

	
}

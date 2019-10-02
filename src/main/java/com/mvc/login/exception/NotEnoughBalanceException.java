package com.mvc.login.exception;

public class NotEnoughBalanceException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7570638241661439328L;

	public NotEnoughBalanceException() {

		super("You dont have enough balance for this action");
	}

	private int code = 2004;

	@Override
	public int getCode() {
		return this.code;
	}
}

package com.mvc.login.exception;

public class TransactionActionException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 155165998382569842L;

	public TransactionActionException() {

		super("an error occured while transfering money");
	}

	private int code = 2007;

	@Override
	public int getCode() {
		return this.code;
	}

}

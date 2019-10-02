package com.mvc.login.exception;

public class NoAccountTypeException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8779390166243204157L;

	public NoAccountTypeException() {

		super("there is no such a currency");
	}

	private int code = 2003;

	@Override
	public int getCode() {
		return this.code;
	}
}

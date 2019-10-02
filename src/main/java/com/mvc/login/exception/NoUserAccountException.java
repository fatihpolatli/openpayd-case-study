package com.mvc.login.exception;

public class NoUserAccountException extends BaseException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8097982270220994987L;

	public NoUserAccountException() {

		super("this account couldnt be found");
	}

	private int code = 2005;

	@Override
	public int getCode() {
		return this.code;
	}

}

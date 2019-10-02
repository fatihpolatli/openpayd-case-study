package com.mvc.login.exception;

public class DuplicateEmailException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateEmailException() {

		super("this email is already exists");
	}

	private int code = 2002;

	@Override
	public int getCode() {
		return this.code;
	}
}

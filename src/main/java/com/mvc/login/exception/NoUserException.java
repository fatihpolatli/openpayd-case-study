package com.mvc.login.exception;

public class NoUserException extends BaseException {

	public NoUserException() {

		super("there is no such a user");
	}

	private int code = 2006;

	@Override
	public int getCode() {
		return this.code;
	}

}

package com.mvc.login.enums;

public enum AccountTypeEnum {

	DR("1"), CR("2");

	private String val;

	AccountTypeEnum(String val) {
		this.val = val;
	}

	public Long val() {
		return Long.parseLong(val);
	}

}

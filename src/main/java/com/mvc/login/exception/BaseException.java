package com.mvc.login.exception;

/**
 * BaseException
 */
public abstract class BaseException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 48165325834513461L;

    public BaseException(String message) {
        super(message);
    }

    public abstract int getCode();

}
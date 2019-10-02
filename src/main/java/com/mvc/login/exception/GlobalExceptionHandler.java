package com.mvc.login.exception;

import com.mvc.login.util.GenericResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * GlobalExceptionHandler
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { BaseException.class })
    protected ResponseEntity<GenericResponse> handleConflict(Exception e, WebRequest request) {

        String code = "500";

        if (e instanceof BaseException) {
            code = ((BaseException) e).getCode() + "";
        }

        GenericResponse res = new GenericResponse(e.getMessage(), code);

        return new ResponseEntity<GenericResponse>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
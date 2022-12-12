package com.warehouse.exception;


import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class BadCredentialsException extends AuthenticationException {

    private static final long serialVersionUID = 1L;

    public BadCredentialsException(String msg) {
        super(msg);
    }

}

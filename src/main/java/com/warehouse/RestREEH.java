package com.warehouse;

import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestREEH extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value= {ArithmeticException.class, BindException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)  
	public  ResponseEntity<Object> handleConflict(
			RuntimeException ex, WebRequest request){
		System.err.println("**** Exception Handler Catched Something ****");
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
}

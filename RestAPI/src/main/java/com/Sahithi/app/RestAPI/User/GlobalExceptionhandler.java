package com.Sahithi.app.RestAPI.User;

import java.util.Date;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionhandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ItemAlreadyExistException.class)
	public ErrorObject haandleItemExistsException(ItemAlreadyExistException ex,WebRequest request){
		
		
		ErrorObject errorObject= new ErrorObject();
		errorObject.setStatusCode(HttpStatus.CONFLICT.value());
		errorObject.setMessage(ex.getMessage());
		errorObject.setTimestamp(new Date());
		return errorObject;
	}
	
	
	
	
}

package com.springrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {
	
	
	
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException e)
	{
		System.out.println("Null pointer");
		ErrorResponse err=new ErrorResponse(HttpStatus.NOT_FOUND,"Id is null",e.getMessage());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
	
@ExceptionHandler(Exception.class)
	
	public ResponseEntity<ErrorResponse> handleException(Exception e,HttpStatus status)
	{
		ErrorResponse err=new ErrorResponse(status,status.name(),e.getMessage());
		System.out.println("exception");
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		
	}
	

}

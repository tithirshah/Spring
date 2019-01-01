package com.springrest.controller;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	
	private HttpStatus errorStatus;
	private String errorName;
	private String message;
	public HttpStatus getErrorStatus() {
		return errorStatus;
	}
	public void setErrorStatus(HttpStatus errorStatus) {
		this.errorStatus = errorStatus;
	}
	public String getErrorName() {
		return errorName;
	}
	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ErrorResponse(HttpStatus errorStatus, String errorName, String message) {
		super();
		this.errorStatus = errorStatus;
		this.errorName = errorName;
		this.message = message;
	}
	

}

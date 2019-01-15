package com.springassign.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(NumberFormatException.class)
	public String handleNumberFormatException(Model m, Exception e)
	{
		System.out.println("Arithmetic exc");
		m.addAttribute("exception",e);
		return "exception";
	}
	
	
	
	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException(Model m, Exception e)
	{
		System.out.println("Runtime exc");
		m.addAttribute("exception",e);
		return "exception";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Model m, Exception e)
	{
		System.out.println("exception");
		m.addAttribute("exception",e);
		return "exception";
	}
	
	

}

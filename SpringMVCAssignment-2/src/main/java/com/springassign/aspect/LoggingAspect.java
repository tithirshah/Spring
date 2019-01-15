package com.springassign.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;



@Aspect
@Component
public class LoggingAspect {

	private static final Logger LOGGER=LoggerFactory.getLogger(LoggingAspect.class);
	@Pointcut("execution(* com.springassign.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.springassign.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.springassign.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* com.springassign.repo.*.*(..))")
	private void forRepoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()||forRepoPackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// display method we are calling
		System.out.println("before");
		String theMethod = theJoinPoint.getSignature().toShortString();
		LOGGER.info("=====>> in @Before: calling method: " + theMethod);
		
		// display the arguments to the method
		
		// get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru and display args
		for (Object tempArg : args) {
			LOGGER.info("=====>> argument: " + tempArg);
		}
		
	}
	
	
	// add @AfterReturning advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
	
		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		LOGGER.info("=====>> in @AfterReturning: from method: " + theMethod);
				
		// display data returned
		LOGGER.info("=====>> result: " + theResult);
	
	}
	
	
//	@Before("execution(public * com.springassign.controller.*.*(..))")
//	public void BeforeLog(JoinPoint jp)
//	{
//		String str=jp.getSignature().getName();
//		Object[] a=jp.getArgs();
//		
//		System.out.println("Method Executed...");
//		LOGGER.info("Method Logger"+str);
//		LOGGER.info("Args are:"+a[0]);
//	}
	
	
	
}

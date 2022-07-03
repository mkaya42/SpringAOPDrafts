package com.mky.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoLoggingAspect {

	// This is where we add all of our related advices for logging

	@Pointcut("execution(* com.mky.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {};
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println(" \n ------> Executing @Before advice on method");
	}
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println(" \n ------> Performing API Analytics");
	}

}

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
	
	//Create a pointcut for getter methods
	@Pointcut("execution(* com.mky.aopdemo.dao.*.get*(..))")
    private void getter() {};
	
	//Create a pointcut for setter methods
	@Pointcut("execution(* com.mky.aopdemo.dao.*.set*(..))")
    private void setter() {};

	//create a pointcut include package exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {};

	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println(" \n ------> Executing @Before advice on method");
	}
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println(" \n ------> Performing API Analytics");
	}

}

package com.mky.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class MyDemoLoggingAspect {

	
	
	@Before("com.mky.aopdemo.aspect.UtilAopDeclarations.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println(" \n ------> Executing @Before advice on method");
	}
	
	
	

}

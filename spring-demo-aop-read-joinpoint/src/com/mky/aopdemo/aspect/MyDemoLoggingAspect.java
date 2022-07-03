package com.mky.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.mky.aopdemo.Account;

@Component
@Aspect
@Order(2)
public class MyDemoLoggingAspect {

	
	
	@Before("com.mky.aopdemo.aspect.UtilAopDeclarations.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println(" \n ------> Executing @Before advice on method");
		
		//Display the method signature
		MethodSignature methodSig =(MethodSignature) theJoinPoint.getSignature();
		System.out.println(" Method : "+methodSig);
		
		//Display method arguments
		
		//Get args
		Object[] args = theJoinPoint.getArgs();
		
		//loop through args
		for(Object tempArg : args) {
			if(tempArg instanceof Account) {
				Account theAccount=(Account) tempArg;
				System.out.println("The Account Name :"+theAccount.getName());
				System.out.println("The Account Level :"+theAccount.getLevel());

			}
		}
	}
	
	
	

}

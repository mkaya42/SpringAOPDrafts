package com.mky.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoLoggingAspect {

	// This is where we add all of our related advices for logging

	// Let's start with an @Before Advice
	// @Before("execution(public void addAccount())")
	// @Before("execution(public void com.mky.aopdemo.dao.AccountDAO.addAccount())")
	// @Before("execution(public void add*())")
	/*
	 * @Before("execution(* add*())") public void beforeAddAccountAdvice() {
	 * System.out.println(" \n ------> Executing @Before advice on add method."); }
	 */
	/*
	 * @Before("execution(* add*(com.mky.aopdemo.Account))") public void
	 * beforeAddAccountAdvice() { System.out.
	 * println(" \n ------> Executing @Before advice on add method with Account parameter."
	 * ); }
	 */
	/*
	 * @Before("execution(* add*(com.mky.aopdemo.Account,..))") public void
	 * beforeAddAccountAdvice() { System.out.
	 * println(" \n ------> Executing @Before advice on add method with Account parameter."
	 * ); }
	 */
	/*
	 * @Before("execution(* add*(..))") public void beforeAddAccountAdvice() {
	 * System.out.
	 * println(" \n ------> Executing @Before advice on add method with Account parameter."
	 * ); }
	 */
	@Before("execution(* com.mky.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		System.out.println(" \n ------> Executing @Before advice on add method with Account parameter.");
	}

}

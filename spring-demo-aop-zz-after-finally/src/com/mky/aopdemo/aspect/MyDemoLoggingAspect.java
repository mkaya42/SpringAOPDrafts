package com.mky.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

	@After("execution(* com.mky.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @After (finally) on method: " 
							+ method);
	
	}
	
	 @AfterThrowing(pointcut = "execution (* com.mky.aopdemo.dao.AccountDAO.findAccounts(..))",throwing = "theExc")
	 public void ThrowingFindAccountsAdvice(JoinPoint theJoinPoint,Throwable theExc) {
		String methodName = theJoinPoint.getSignature().toShortString();
		System.out.println("\n ------> Executing @AfterThrowing method "+methodName);
		
		//Log The Exception
		System.out.println("The exception is "+theExc);
		
	 }
	
	
	
	@AfterReturning(pointcut = "execution(* com.mky.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		//Print out the method name which we are advising on
		String methodName = theJoinPoint.getSignature().toShortString();
		System.out.println("\n ------> Executing @AfterReturning method "+methodName);
		
		//Print out the results of the method call
		 System.out.println("result is"+result);
		 System.out.println("\n");
		 
		 // Lets modify the data
		 //Convert the account names to uppercase letters
		 convertAccountNamesToUpperCase(result);
		 System.out.println("result is "+result);
		 System.out.println("\n");
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		//loop through accounts
		for(Account tempAccount:result) {
			//get the uppercase version of name
			
			String theUpperName=tempAccount.getName().toUpperCase();
			//update the account name
			tempAccount.setName(theUpperName);
		}
		
		
		
	}

	@Before("com.mky.aopdemo.aspect.UtilAopDeclarations.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println(" \n ------> Executing @Before advice on method");

		// Display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println(" Method : " + methodSig);

		// Display method arguments

		// Get args
		Object[] args = theJoinPoint.getArgs();

		// loop through args
		for (Object tempArg : args) {
			if (tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				System.out.println("The Account Name :" + theAccount.getName());
				System.out.println("The Account Level :" + theAccount.getLevel());

			}
		}
	}

}

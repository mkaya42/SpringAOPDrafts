package com.mky.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.mky.aopdemo.Account;
import com.mky.aopdemo.AroundWithLoggerDemoApp;

@Component
@Aspect
@Order(2)
public class MyDemoLoggingAspect {

	private  Logger myLogger = Logger.getLogger(getClass().getName());

	
	@Around("execution(* com.mky.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune (ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		
		//print out the method we are advising on 
		// print out which method we are advising on
				String method = theProceedingJoinPoint.getSignature().toShortString();
				myLogger.info("\n=====>>> Executing @Around on method: " 
									+ method);
		
		//get begin time stamp
		long begin =System.currentTimeMillis();
		
		//now lets execute the method
		Object result=null;
		
		try {
			result=theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			
			//log the exception 
			myLogger.warning(e.getMessage());
			/*or give user a custom fortune, handling exception and sendin a normal message to main , main does not know exception
			  result="Major accident But no worries your private AOP Helicopter is on the way";*/
			
			//throwing exception , main will know the exception
			throw e;
		}
		
		//get end time stamp
		long end =System.currentTimeMillis();

		//compute duration
		long duration = end-begin;
		myLogger.info(" Duration ---->> "+duration/1000.0+" miliseconds");
		return result;
	} 
	
	
	@After("execution(* com.mky.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @After (finally) on method: " 
							+ method);
	
	}
	
	 @AfterThrowing(pointcut = "execution (* com.mky.aopdemo.dao.AccountDAO.findAccounts(..))",throwing = "theExc")
	 public void ThrowingFindAccountsAdvice(JoinPoint theJoinPoint,Throwable theExc) {
		String methodName = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n ------> Executing @AfterThrowing method "+methodName);
		
		//Log The Exception
		myLogger.info("The exception is "+theExc);
		
	 }
	
	
	
	@AfterReturning(pointcut = "execution(* com.mky.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		//Print out the method name which we are advising on
		String methodName = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n ------> Executing @AfterReturning method "+methodName);
		
		//Print out the results of the method call
		 myLogger.info("result is"+result);
		 myLogger.info("\n");
		 
		 // Lets modify the data
		 //Convert the account names to uppercase letters
		 convertAccountNamesToUpperCase(result);
		 myLogger.info("result is "+result);
		 myLogger.info("\n");
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
		myLogger.info(" \n ------> Executing @Before advice on method");

		// Display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info(" Method : " + methodSig);

		// Display method arguments

		// Get args
		Object[] args = theJoinPoint.getArgs();

		// loop through args
		for (Object tempArg : args) {
			if (tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				myLogger.info("The Account Name :" + theAccount.getName());
				myLogger.info("The Account Level :" + theAccount.getLevel());

			}
		}
	}

}

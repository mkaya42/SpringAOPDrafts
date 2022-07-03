package com.mky.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mky.aopdemo.dao.AccountDAO;
import com.mky.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Read configuration class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO=context.getBean("accountDAO",AccountDAO.class);
		
		
		List<Account> theAccounts = theAccountDAO.findAccounts(false);
		
		System.out.println("Main Program after returning");
		System.out.println(theAccounts);
		System.out.println("\n");
		
		//close the context
		context.close();
		
	}

}

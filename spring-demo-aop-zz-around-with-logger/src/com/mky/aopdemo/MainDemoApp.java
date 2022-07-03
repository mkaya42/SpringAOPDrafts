package com.mky.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mky.aopdemo.dao.AccountDAO;
import com.mky.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Read configuration class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO=context.getBean("accountDAO",AccountDAO.class);
		MembershipDAO theMembershipDAO=context.getBean("membershipDAO",MembershipDAO.class);
		
		//call the business method
		Account account = new Account();
		account.setName("Mustafa");
		account.setLevel("001");
		theAccountDAO.addAccount(account);
		theAccountDAO.doWork();

		//call accountdao getter and setters
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String serviceCode =theAccountDAO.getServiceCode();
		
		theMembershipDAO.addAccount(account,true);
		theMembershipDAO.addSillyMethod();
		theMembershipDAO.goToSleep();
		//close the context
		context.close();
		
	}

}

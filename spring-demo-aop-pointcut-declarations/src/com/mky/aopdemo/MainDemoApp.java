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
		theAccountDAO.addAccount(account);
		theMembershipDAO.addAccount(account,true);
		theMembershipDAO.addSillyMethod();
		theMembershipDAO.goToSleep();
		//close the context
		context.close();
		
	}

}

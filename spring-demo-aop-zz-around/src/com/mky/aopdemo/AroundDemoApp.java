package com.mky.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mky.aopdemo.dao.AccountDAO;
import com.mky.aopdemo.dao.MembershipDAO;
import com.mky.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Read configuration class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		TrafficFortuneService theFortuneService=context.getBean("trafficFortuneService",TrafficFortuneService.class);
		System.out.println("\n Main Program AroundDemoApp");
		System.out.println("\n Calling getFortune");

		String data = theFortuneService.getFortune();
		System.out.println("\n My Fortune is "+data);
		System.out.println("\n Finished");
		//close the context
		context.close();
		
	}

}

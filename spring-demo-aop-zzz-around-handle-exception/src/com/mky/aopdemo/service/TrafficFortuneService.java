package com.mky.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		
		//simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//We handled exception.
		return "Expect heavy traffic in this morning";
	}

	/*Simulating an exception*/
	public String getFortune(boolean tripWare) {
	
		if(tripWare) {
			throw new RuntimeException("Major Highway is closed!");
		}
		
		return getFortune();
	}
}

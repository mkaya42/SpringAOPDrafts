package com.mky.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.mky.aopdemo.Account;

@Component
public class MembershipDAO {

	public void addAccount(Account account,boolean flag) {
		System.out.println(getClass()+ " Doing my membership db work");
		
	}
	public boolean addSillyMethod() {
		System.out.println(getClass()+ " Doing my membership silly db work");
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass()+ " i m going to sleep now");

	}
}

package com.mky.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mky.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	
	public List<Account> findAccounts(){
		
		List<Account> myAccounts = new ArrayList<>();
		
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Madhu", "Platinium");
		Account temp3 = new Account("Luca", "Gold");

		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);

		return myAccounts;
		
	}
	
	
	
	public void addAccount(Account account) {
		System.out.println(getClass() + ": Doing my db work adding an account");
	}

	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");

		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");

		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");

		this.serviceCode = serviceCode;
	}
	
	
}

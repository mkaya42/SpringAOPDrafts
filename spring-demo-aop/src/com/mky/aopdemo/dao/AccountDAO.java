package com.mky.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.mky.aopdemo.Account;

@Component
public class AccountDAO {
public void addAccount(Account account) {
	System.out.println(getClass()+ " Doing my db work");
}
}

package com.security.service;

import org.springframework.security.core.userdetails.User;

import com.security.model.Account;

@SuppressWarnings("serial")
public class AccountUserDetails extends User {

	private Account account;

	public AccountUserDetails(Account account) {
		super(account.getUsername(), account.getPassword(), account.getAuthorities());
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}

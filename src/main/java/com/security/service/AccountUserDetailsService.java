package com.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.model.Account;

@Service
public class AccountUserDetailsService implements UserDetailsService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	AccountResolverService accountResolverService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Account account = accountResolverService.findUserByUserName(username);
			// (2)
			return new AccountUserDetails(account);
		} catch (Exception e) {
			logger.error("Unkonwn Error", e);
			throw new UsernameNotFoundException("user not found", e);
		}
	}

	public void setAccountResolverService(AccountResolverService accountResolverService) {
		this.accountResolverService = accountResolverService;
	}

}

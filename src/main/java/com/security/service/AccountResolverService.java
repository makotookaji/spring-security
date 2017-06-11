package com.security.service;

import java.util.Iterator;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.model.Account;

@Service
public class AccountResolverService {

	private static final ImmutableList<Account> REPOSITORY;
	static {
	Account admin = new Account(
								  "admin"
								, "admin"
								, "Paul"
								, "Mccartney"
								, "Male"
								, "England"
								, "Merseyside"
								, "Liverpool"
								, AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_ADMIN")
								);
	Account user = new Account(
								  "user"
								, "user"
								, "Mick"
								, "Jagger"
								, "Male"
								, "England"
								, "Kent"
								, "Dartford"
								, AuthorityUtils.createAuthorityList("ROLE_USER")
								);
	
	Account hoge = new Account(
								 "hoge"
								, "hoge"
								, "Jimmy"
								, "Page"
								, "Male"
								, "England"
								, "Middlesex"
								, "Heston"
								, AuthorityUtils.createAuthorityList("ROLE_USER")
								);
	REPOSITORY = Lists.immutable.of(admin,user,hoge);
	
	}

	public Account findUserByUserName(String username) {
		Account account = null;
		Iterator<Account> iterator = REPOSITORY.iterator();
				
		for (;iterator.hasNext();) {
			Account tempAccount = iterator.next();
			if (tempAccount.getUsername().equals(username)) {
				account = tempAccount;
				break;
			}
		}

		if (account == null) {
			throw new UsernameNotFoundException("The given account is not found! username=" + username);
		}
		return account;
	}
}

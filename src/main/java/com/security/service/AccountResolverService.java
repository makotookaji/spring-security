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
		Account admin = new Account(//
				"admin" // Username
				, "admin" // Password
				, "Paul" // First name
				, "Mccartney" // Last name
				, "Male" // Gender
				, "England" // Country
				, "Liverpool" // City
				, AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN") // Authorities
		);
		Account user = new Account(//
				"user" // Username
				, "user"// Password
				, "Mick"// First name
				, "Jagger"// Last name
				, "Male"// Gender
				, "England"// Country
				, "Dartford"// City
				, AuthorityUtils.createAuthorityList("ROLE_USER") // Authorities
		);

		Account hoge = new Account( //
				"hoge" // Username
				, "hoge" // Password
				, "Jimmy" // First name
				, "Page" // Last name
				, "Male" // Gender
				, "England" // Country
				, "Heston" // City
				, AuthorityUtils.createAuthorityList("ROLE_USER")// Authorities
		);
		REPOSITORY = Lists.immutable.of(admin, user, hoge);

	}

	public Account findUserByUserName(String username) {
		Account account = null;
		Iterator<Account> iterator = REPOSITORY.iterator();

		for (; iterator.hasNext();) {
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

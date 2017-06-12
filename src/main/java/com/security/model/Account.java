package com.security.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.StringUtils;

public class Account {

	private String username;

	private String password;

	private String firstName;

	private String lastName;

	private String gender;

	private String country;

	private String city;

	private List<GrantedAuthority> authorities;

	public Account(String username, String password, String firstName, String lastName, String gender, String country,
			String city, List<GrantedAuthority> authorities) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.country = country;
		this.city = city;
		this.authorities = authorities;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	public List<String> getAuthoritiesString() {
		List<String> ret = new ArrayList<String>();
		Iterator<GrantedAuthority> iterator = this.authorities.iterator();
		for (; iterator.hasNext();) {
			GrantedAuthority auth = iterator.next();
			ret.add(auth.getAuthority());
		}
		return ret;
	}

	@Override
	public String toString() {
		return "Account [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", gender=" + gender + ", country=" + country + ", city=" + city + ", authorities="
				+ StringUtils.toStringArray(this.getAuthoritiesString()) + "]";
	}
}

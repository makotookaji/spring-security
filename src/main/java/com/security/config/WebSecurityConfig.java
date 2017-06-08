package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/**").permitAll()
				.antMatchers("/users/**").hasRole("USER")
				.antMatchers("/admins/**").hasRole("ADMIN")
				.and().formLogin()
				.loginPage("/login").permitAll().failureUrl("/login-error");
	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		System.out.println("vvvv");
//		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER").and().withUser("admin")
//				.password("admin").roles("ADMIN");
//	}
//
//	@Bean
//	@Override
//	protected AuthenticationManager authenticationManager() throws Exception {
//		System.out.println("DDDDDDDDDDD");
//		return super.authenticationManager();
//	}
//
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("user").password("user").roles("USER").build());
		manager.createUser(User.withUsername("admin").password("admin").roles("ADMIN").build());
		manager.createUser(User.withUsername("sys").password("sys").roles("USER","ADMIN").build());
		return manager;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService());
	}
	
}
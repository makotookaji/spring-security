package com.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.security.model.Account;
import com.security.service.AccountUserDetails;

@Controller
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = { "/", "/loginForm" })
	public ModelAndView login() {
		logger.debug("login");
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;

	}

	@RequestMapping(value = "/welcome")
	public ModelAndView welcome() {
		logger.debug("welcome");
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Welcome");
		model.addObject("message", "This is Welcome page!");
		model.setViewName("welcome");
		return model;
	}

	@RequestMapping(value = "/mypage")
	public ModelAndView mypage() {
		logger.debug("mypage");
		ModelAndView model = new ModelAndView();
		model.setViewName("mypage");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth.getPrincipal() instanceof AccountUserDetails) {
			AccountUserDetails accountUser = AccountUserDetails.class.cast(auth.getPrincipal());
			Account account = accountUser.getAccount();
			model.addObject("username", account.getUsername());
			model.addObject("realname", account.getFirstName() + " " + account.getLastName());
			model.addObject("authorities", account.getAuthoritiesString());
			model.addObject("address", account.getCountry() + " , " + account.getCity());
			model.addObject("gender", account.getGender());
		} else {
			UserDetails user = UserDetails.class.cast(auth.getPrincipal());
			model.addObject("username", user.getUsername());
			model.addObject("authorities", user.getAuthorities().toArray());
		}
		return model;
	}

	@RequestMapping(value = "/user")
	public ModelAndView userPage() {
		logger.debug("user");
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello user");
		model.addObject("message", "This is User page!");
		model.setViewName("user");

		return model;

	}

	@RequestMapping(value = "/admin")
	public ModelAndView adminPage() {
		logger.debug("admin");
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello admin");
		model.addObject("message", "This is Admin page!");
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/403error")
	public ModelAndView error403() {
		logger.debug("error403");
		ModelAndView model = new ModelAndView();
		model.setViewName("error/error403");

		return model;
	}

}
package com.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class LoginController {

//	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = {"/","/welcome**"}, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
System.out.println("login");
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is login page!");
		model.setViewName("index");
		return model;

	}

	@RequestMapping(value = "/user**", method = RequestMethod.GET)
	public ModelAndView userPage() {
		System.out.println("user");
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World user");
		model.addObject("message", "This is protected page!");
		model.setViewName("user");

		return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		System.out.println("admin");
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World admin");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");

		return model;

	}
	@RequestMapping(value = "/sys**", method = RequestMethod.GET)
	public ModelAndView sysPage() {
		System.out.println("sys");
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World sys");
		model.addObject("message", "This is protected page!");
		model.setViewName("sys");

		return model;

	}



}


package com.arsoft.projects.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArCommonBaseController {
	
	private static final String VIEW_INDEX = "index";
	private static final String VIEW_CONTACT = "contact";
	private static final String VIEW_HOME = "home";
	private static final String VIEW_PRODUCTS = "products";
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(ModelMap model) {
		return VIEW_INDEX;
	}
	
	@RequestMapping(value = "contact", method = RequestMethod.GET)
	public String contactUs(ModelMap model) {
		return VIEW_CONTACT;
	}
	
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(ModelMap model) {
		return VIEW_HOME;
	}
	
	@RequestMapping(value = "products", method = RequestMethod.GET)
	public String products(ModelMap model) {
		return VIEW_PRODUCTS;
	}
	
}

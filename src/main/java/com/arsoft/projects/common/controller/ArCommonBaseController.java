package com.arsoft.projects.common.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ArCommonBaseController {
	
	private static final String VIEW_INDEX = "index";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

	}
	
	@RequestMapping(value = "/arcommon-1.0/", method = RequestMethod.GET)
	public String welcomeOne(ModelMap model) {

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

	}
}

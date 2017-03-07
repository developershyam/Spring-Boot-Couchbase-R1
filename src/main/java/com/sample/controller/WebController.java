package com.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This is web controller used to expose URL for application access.
 * 
 * @author shyam.pareek
 *
 */
@Controller
public class WebController {

	@RequestMapping({ "/", "/welcome" })
	String home() {
		return "welcome";
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error(Model model) {

		return "error";
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String books(Model model) {

		return "books";
	}

}

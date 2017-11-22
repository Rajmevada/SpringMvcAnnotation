package com.rajmevada.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * these class is responded to manage which method has been invoked for which URL.
 * @author raj
 */
@Controller
@RequestMapping("/")
public class RequestController {

	@RequestMapping(method = RequestMethod.GET)
	public String defaultMethod(ModelMap map) {
		map.addAttribute("msg", "Hello World ...");
		return "welcome";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/sec")
	public String secondRequest(ModelMap map) {
		map.addAttribute("msg", "This is second one request");
		return "home";
	}
}

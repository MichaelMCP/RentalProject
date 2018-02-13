package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin(origins="http://50.207.204.190:4200")
public class HomeController {
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String getHomepage(HttpSession s) {
		if(s.getAttribute("user")!=null)
			return "/home.html";
		else
			return "redirect: login";
	}
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession s) {
		s.invalidate();
		return "redirect: login";
	}
}
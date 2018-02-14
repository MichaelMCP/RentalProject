package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.User;
import com.revature.service.LoginService;

@Controller
@CrossOrigin(origins= {"*"})
@RequestMapping(value="/login")
public class LoginController {
	@Autowired
	private LoginService login;
	
	public void setLogin(LoginService login) {
		this.login = login;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String goLogin(HttpSession session) {
		if(session.getAttribute("user")!=null)
			return "home";
		return "login";
	}
	
	@RequestMapping(value="/login2", method=RequestMethod.POST)
	public String login(@RequestBody User user, HttpSession session) {
		User u = login.login(user.getEmail(), user.getPass());
		if(u == null) {
			return "redirect:login";
		} else {
			session.setAttribute("user", u);
			return "redirect:home";
		}
			
	}
}
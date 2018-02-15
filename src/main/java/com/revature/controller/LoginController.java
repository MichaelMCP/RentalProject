package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.service.LoginService;

@Controller
@CrossOrigin(origins= {"*"})
@RequestMapping(value="/login")
public class LoginController {
	private ObjectMapper om = new ObjectMapper();
	private Logger log = Logger.getLogger(LoginController.class);
	@Autowired
	private LoginService login;
	
	public void setLogin(LoginService login){
		
		this.login = login;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String goLogin(HttpSession session) {
		log.trace(session);
		if(session.getAttribute("user")!=null)
			return "home";
		return "login";
	}
	
<<<<<<< HEAD
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String login(@RequestBody User user, HttpSession session) throws JsonProcessingException {
=======
	@RequestMapping(value="/login2", method=RequestMethod.POST)
	public String login(@ModelAttribute("user") User user, HttpSession session) {
>>>>>>> 8203a7bad469807dcb8843f68d3433c4e97ca690
		User u = login.login(user.getEmail(), user.getPass());
		log.error(session);
		log.error(u);
		if(u == null) {
			return null;
		} else {
			session.setAttribute("user", u);
			return om.writeValueAsString(u);
			
		}
			
	}
}
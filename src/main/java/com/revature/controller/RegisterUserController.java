package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.service.RegisterUserService;

@Controller
@CrossOrigin(origins= {"*"})
@RequestMapping(value="/register")
public class RegisterUserController 
{
	private ObjectMapper om = new ObjectMapper();
	private Logger log = Logger.getLogger(RegisterUserController.class);
	@Autowired
	private RegisterUserService register;
	
	public void setLogin(RegisterUserService register){
		
		this.register = register;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String register(@RequestBody User user, HttpSession session) throws JsonProcessingException {
		User u = register.registerUser(user.getEmail(), user.getPass(), user.getFullName(), user.getRole());
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

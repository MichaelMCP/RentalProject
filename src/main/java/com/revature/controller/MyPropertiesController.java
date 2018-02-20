package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Property;
import com.revature.beans.User;
import com.revature.service.MyPropertiesService;


@Controller
@CrossOrigin(origins= {"*"})
@RequestMapping(value="/my-properties")
public class MyPropertiesController {
	private ObjectMapper om = new ObjectMapper();
	@Autowired
	private MyPropertiesService mypro;
	
	public void setProperties(MyPropertiesService mypro) {
		this.mypro = mypro;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public String showProperties(HttpSession session) throws JsonProcessingException {
		User user = (User) session.getAttribute("user");
		return om.writeValueAsString(mypro.getMyProperties(user.getId()));
	}
	@RequestMapping(method=RequestMethod.POST)
	public String deleteProperties(@RequestBody Property property, HttpSession session){
		mypro.deleteMyProperty(property);
		return "redirect: my-properties";
	}
	
}

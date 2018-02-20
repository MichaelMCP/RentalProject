package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.service.AllPropertiesService;

@Controller
@CrossOrigin(origins= {"*"})
@RequestMapping(value="/Properties")
public class AllPropertiesController {
	private ObjectMapper om = new ObjectMapper();
	@Autowired
	private AllPropertiesService allpro;
	
	public void setProperties(AllPropertiesService allpro) {
		this.allpro = allpro;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public String showProperties(HttpSession session) throws JsonProcessingException {
		return om.writeValueAsString(allpro.getAllPropertiesAvailable());
	}
}

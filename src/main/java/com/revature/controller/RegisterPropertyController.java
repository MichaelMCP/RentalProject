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
import com.revature.beans.Property;
import com.revature.beans.User;
import com.revature.service.RegisterPropertyService;

@Controller
@CrossOrigin(origins= {"*"})
@RequestMapping(value="/register-property")
public class RegisterPropertyController {

	private ObjectMapper om = new ObjectMapper();
	private Logger log = Logger.getLogger(RegisterUserController.class);
	
	@Autowired
	private RegisterPropertyService rps;
	
	public void setRegisterPropertyService(RegisterPropertyService rps) {
		this.rps = rps;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String registerProperty(@RequestBody Property property, HttpSession session) throws JsonProcessingException {
		
		User u = (User)session.getAttribute("user");
		Property props = rps.registerProperty(u , property.getAddress1(), property.getAddress2(), property.getAddress2(), property.getCity(),
				property.getZipcode(), property.getCurrentRentPrice(), property.getRating(), property.getAvailability());

		rps.updateRole(u);
		
		log.error(session);
		log.error(props);
		if(u == null) {
			return null;
		} else {
			return om.writeValueAsString(props);	
		}	
	}
}

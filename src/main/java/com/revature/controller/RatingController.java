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
import com.revature.service.RatingService;

@Controller
@CrossOrigin(origins= {"*"})
@RequestMapping(value="/rating")
public class RatingController {
	private ObjectMapper om = new ObjectMapper();
	@Autowired
	private RatingService rating;
	
	public void setProperties(RatingService rating) {
		this.rating = rating;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public String showProperties(HttpSession session) throws JsonProcessingException {
		User user = (User) session.getAttribute("user");
		return om.writeValueAsString(rating.getRentedProperties(user.getId()));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String updateProperties(@RequestBody Property property, HttpSession session) throws JsonProcessingException {
		return om.writeValueAsString(rating.rateProperty(property));
	}

}

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
import com.revature.beans.User;
import com.revature.service.EditUserService;


@Controller
@CrossOrigin(origins= {"*"})
@RequestMapping(value="/editUsers")
public class EditUserController {
	private ObjectMapper om = new ObjectMapper();
	@Autowired
	private EditUserService editUser;
	
	public void setProperties(EditUserService editUser) {
		this.editUser = editUser;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public String showAllUser(HttpSession session) throws JsonProcessingException {
		return om.writeValueAsString(editUser.getAllUser());
	}
	@RequestMapping(method=RequestMethod.POST)
	public String deleteProperties(@RequestBody User user, HttpSession session){
		editUser.deleteUser(user);
		return "redirect: editUsers";
	}
	
}


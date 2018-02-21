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
import com.revature.beans.RentTransaction;
import com.revature.data.RentTransactionHibernate;
import com.revature.service.RentTransactionService;

//TO DO FIX BY ADDING NEWLY CREATED SERVICE
@Controller
@CrossOrigin(origins= {"*"})
@RequestMapping(value="/rentTransaction")
public class RentTransactionController 
{
	private ObjectMapper om = new ObjectMapper();
	@Autowired
	private RentTransactionService register;
	
	public void setRentTransaction(RentTransactionService register){
		
		this.register = register;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String register(@RequestBody RentTransaction rentT, HttpSession session) throws JsonProcessingException {
		RentTransaction v = register.registerRentTransaction(rentT);
		if(v == null) {
			return null;
		} else {
			session.setAttribute("rentTransaction", v);
			return om.writeValueAsString(v);
			
		}
			
	}
}

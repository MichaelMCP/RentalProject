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
import com.revature.beans.PaymentInfo;
import com.revature.beans.User;
import com.revature.service.PaymentService;

@Controller
@CrossOrigin(origins= {"*"})
@RequestMapping(value="/paymentHandler")
public class PaymentController {
	private ObjectMapper om = new ObjectMapper();
	@Autowired
	private PaymentService payment;
	
	public void setPaymentInfo(PaymentService payment){
		this.payment = payment;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String addPayment(@RequestBody PaymentInfo paymentInfo, HttpSession session) throws JsonProcessingException {
		User u = null;
		u = (User) session.getAttribute("user");
		PaymentInfo pyInfo = null;
		pyInfo.setUser(u);
		pyInfo= payment.savePaymentInfo(paymentInfo);
		return om.writeValueAsString(pyInfo);
			
	}

}

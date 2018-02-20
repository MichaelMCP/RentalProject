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
import com.revature.beans.PaymentInfo;
import com.revature.service.PaymentService;
import com.revature.service.RegisterUserService;

@Controller
@CrossOrigin(origins= {"*"})
@RequestMapping(value="/Payment")
public class PaymentController {
	private ObjectMapper om = new ObjectMapper();
	private Logger log = Logger.getLogger(PaymentController.class);
	@Autowired
	private PaymentService payment;
	
	public void setPaymentInfo(PaymentService payment){
		this.payment = payment;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String addPayment(@RequestBody PaymentInfo paymentInfo, HttpSession session) throws JsonProcessingException {
		PaymentInfo pyInfo= payment.savePaymentInfo(paymentInfo);
		log.error(paymentInfo);
		return om.writeValueAsString(pyInfo);
			
	}

}

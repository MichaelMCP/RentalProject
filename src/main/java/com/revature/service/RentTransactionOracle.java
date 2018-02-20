package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.PaymentInfo;
import com.revature.beans.Property;
import com.revature.beans.RentTransaction;
import com.revature.beans.User;
import com.revature.data.RentTransactionDao;

@Service
public class RentTransactionOracle implements RentTransactionService {
	
	@Autowired
	RentTransactionDao ud;
	@Override
	public RentTransaction registerRentTransaction(String startdate, String enddate, User user, Property property, int approval,
			PaymentInfo paymentInfo) {
		RentTransaction nu = new RentTransaction(0, startdate,  enddate,  user,  property, approval,  paymentInfo );
		ud.createRentTransaction(nu);
		return nu;
	}

}

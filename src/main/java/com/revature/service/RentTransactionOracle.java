package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.PaymentInfo;
import com.revature.beans.Property;
import com.revature.beans.RentTransaction;
import com.revature.beans.User;
import com.revature.data.PaymentInfoDao;
import com.revature.data.PropertyDao;
import com.revature.data.RentTransactionDao;
import com.revature.data.UserDao;

@Service
public class RentTransactionOracle implements RentTransactionService {
	
	@Autowired
	RentTransactionDao rtd;
	@Autowired
	UserDao ud;
	@Autowired
	PropertyDao pd;
	@Autowired
	PaymentInfoDao pid;
	
	@Override
	public RentTransaction registerRentTransaction(RentTransaction rt) {
		User u = rt.getRenter();
		User newu = ud.getUserById(u.getId());
		rt.setRenter(newu);
		
		Property prop = rt.getProperty();
		Property newprop = pd.getPropertyByPropertyId(prop.getPropertyId());
		newprop.setAvailability(0);
		
		pd.updateProperty(newprop);
		
		PaymentInfo pi = pid.getPaymentInfoByUserId(newu.getId());
		rt.setPayment(pi);
		
		rt.setApproval(1);
		rtd.createRentTransaction(rt);
		return rt;
	}

}

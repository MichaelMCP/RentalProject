package com.revature.service;

<<<<<<< HEAD
=======

>>>>>>> 91da524b89c4b9203c8aad2af53a485634702e0d
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.PaymentInfo;
import com.revature.data.PaymentInfoDao;

public class PaymentOracle implements PaymentService {
	@Autowired
	PaymentInfoDao pd;

	@Override
	public PaymentInfo savePaymentInfo(PaymentInfo paymentInfo) {
		pd.createPaymentInfo(paymentInfo);
		return paymentInfo;
	}

}

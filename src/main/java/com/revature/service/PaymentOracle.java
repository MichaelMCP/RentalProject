package com.revature.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.PaymentInfo;
import com.revature.data.PaymentInfoDao;

@Service
public class PaymentOracle implements PaymentService {
	@Autowired
	PaymentInfoDao pd;

	@Override
	public PaymentInfo savePaymentInfo(PaymentInfo paymentInfo) {
		pd.createPaymentInfo(paymentInfo);
		return paymentInfo;
	}

}

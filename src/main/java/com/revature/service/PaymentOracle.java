package com.revature.service;


import java.util.List;

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
		
		
		boolean b = false;
		List<PaymentInfo> pi = pd.getAllPaymentInfo();
		
		if(pi == null)
		{
			pd.createPaymentInfo(paymentInfo);
			b = true;
		}
		else
		{
			for(int i = 0; i < pi.size(); i++)
			{
				if(pi.get(i).getUser().getId() == paymentInfo.getUser().getId())
				{
					paymentInfo.setId(pi.get(i).getId());
					pd.updatePaymentInfo(paymentInfo);
					b = true;
				}
			}
			
			if(b == false)
			{
				pd.createPaymentInfo(paymentInfo);
			}
		}
		
		
		return paymentInfo;
	}

}

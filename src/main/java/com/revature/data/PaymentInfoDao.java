package com.revature.data;

import java.util.List;

import com.revature.beans.PaymentInfo;

public interface PaymentInfoDao {
	
	public PaymentInfo createPaymentInfo(PaymentInfo p);
	
	public PaymentInfo getPaymentInfoById(int i);
	
	public List<PaymentInfo> getAllPaymentInfo();
	
	public PaymentInfo updatePaymentInfo(PaymentInfo p);
	
	public void deletePaymentInfo(PaymentInfo p);

}

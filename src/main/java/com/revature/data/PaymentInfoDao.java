package com.revature.data;

import java.util.List;

import com.revature.beans.PaymentInfo;

public interface PaymentInfoDao {
	
	public int createPaymentInfo(PaymentInfo p);
	
	public PaymentInfo getPaymentInfoById(int i);
	
	public List<PaymentInfo> getAllPaymentInfo();
	
	public PaymentInfo updatePaymentInfo(PaymentInfo p);
	
	public int deletePaymentInfo(PaymentInfo p);

}

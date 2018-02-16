package com.revature.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.PaymentInfo;
import com.revature.util.HibernateUtil;

public class PaymentInfoHibernate implements PaymentInfoDao, HibernateSession{
	
	private Session session;

	@Override
	public PaymentInfo createPaymentInfo(PaymentInfo p){
		int i = (Integer) session.save(p);
		return p;
	}

	@Override
	public PaymentInfo getPaymentInfoById(int i) {
		PaymentInfo p = (PaymentInfo) session.get(PaymentInfo.class, i);
		return p;
	}

	@Override
	public List<PaymentInfo> getAllPaymentInfo() {
		String query = "from com.revature.beans.PaymentInfo";
		List<PaymentInfo> q = (List<PaymentInfo>) session.createQuery(query, PaymentInfo.class);
		return q;
	}

	@Override
	public PaymentInfo updatePaymentInfo(PaymentInfo p) {
		session.update(p);
		return p;
	}

	@Override
	public void deletePaymentInfo(PaymentInfo p) {
		session.delete(p);
	}

	@Override
	public void setSession(Session session) {
		this.session = session;
	}

}

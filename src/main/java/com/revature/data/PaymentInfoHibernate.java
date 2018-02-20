package com.revature.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.PaymentInfo;
import com.revature.util.HibernateUtil;

@Repository
public class PaymentInfoHibernate implements PaymentInfoDao, HibernateSession{
	
	private Session session;

	@Override
	public PaymentInfo createPaymentInfo(PaymentInfo p){
		session.save(p);
		return p;
	}

	@Override
	public PaymentInfo getPaymentInfoById(int i) {
		return (PaymentInfo) session.get(PaymentInfo.class, i);
	}

	@Override
	public List<PaymentInfo> getAllPaymentInfo() {
		String query = "from com.revature.beans.PaymentInfo";
		return (List<PaymentInfo>) session.createQuery(query, PaymentInfo.class);
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

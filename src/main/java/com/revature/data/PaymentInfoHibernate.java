package com.revature.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.beans.PaymentInfo;

@Repository
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
		String hquery = "from com.revature.beans.PaymentInfo";
		List<PaymentInfo> pl = (List<PaymentInfo>) session.createQuery(hquery).list();
		return pl;
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

	@Override
	public PaymentInfo getPaymentInfoByUserId(int i) {
		String hquery = "from com.revature.beans.PaymentInfo where user_id = :user_id";
		Query q = session.createQuery(hquery);
		q.setParameter("user_id", i);
		PaymentInfo p = (PaymentInfo) q.uniqueResult();
		return p;
	}

}

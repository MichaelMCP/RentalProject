package com.revature.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.PaymentInfo;
import com.revature.util.HibernateUtil;

public class PaymentInfoHibernate implements PaymentInfoDao{
	
	private static Logger log = Logger.getLogger(PaymentInfoHibernate.class);
	private static HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public int createPaymentInfo(PaymentInfo p) {
		Session session = hu.getSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			log.warn("The payment info is: "+p);
			int i = (Integer) session.save(p);
			log.warn("Created payment info will have an id of "+i);
			log.warn("The payment info is: "+p);
			
			
			tx.commit();
			
			return p.getId();
			
		} catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
			return 0;
		} finally {
			session.close();
		}
	}

	@Override
	public PaymentInfo getPaymentInfoById(int i) {
		Session su = hu.getSession();
		PaymentInfo p = su.get(PaymentInfo.class, i);
		su.close();
		return p;
	}

	@Override
	public List<PaymentInfo> getAllPaymentInfo() {
		Session s = hu.getSession();
		String query = "from com.revature.beans.PaymentInfo";
		Query<PaymentInfo> q = s.createQuery(query, PaymentInfo.class);
		List<PaymentInfo> paymentInfoList = q.getResultList();
		s.close();
		return paymentInfoList;
	}

	@Override
	public PaymentInfo updatePaymentInfo(PaymentInfo p) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.update(p);
		tx.commit();
		s.close();
		return p;
	}

	@Override
	public int deletePaymentInfo(PaymentInfo p) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(p);
		tx.commit();
		s.close();
		return 1;
	}

}

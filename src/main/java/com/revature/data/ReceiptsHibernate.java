package com.revature.data;

import java.util.List;


import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Receipt;
import com.revature.util.HibernateUtil;

public class ReceiptsHibernate implements ReceiptsDao {
	
	private static Logger log = Logger.getLogger(PaymentInfoHibernate.class);
	private static HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public int createRecepit(Receipt receipt){
		Session session = hu.getSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			log.warn("The Receipt is: "+receipt);
			int i = (Integer) session.save(receipt);
			log.warn("Created Receipt will have an id of "+i);
			log.warn("The Receipt is: "+receipt);
			
			tx.commit();
			
			return receipt.getReceiptId();
			
		} catch(Exception e) {
			log.trace(e);
			return 0;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Receipt> getReceiptByRenterId(int i) {
		Session s = hu.getSession();
		String query = "from com.revature.beans.Receipt re where re.renterUserId=:renterId";
		log.trace(s);
		Query<Receipt> q = s.createQuery(query, Receipt.class);
		q.setParameter("renterId", i);
		log.trace(q);
		List<Receipt> receiptList = q.getResultList();
		s.close();
		return receiptList;
	}

	@Override
	public List<Receipt> getReceiptByOwnerId(int i) {
		Session s = hu.getSession();
		String query = "from com.revature.beans.Receipt re where re.ownerUserId=:ownerId";
		log.trace(s);
		Query<Receipt> q = s.createQuery(query, Receipt.class);
		q.setParameter("ownerId", i);
		log.trace(q);
		List<Receipt> receiptList = q.getResultList();
		s.close();
		return receiptList;
	}

	@Override
	public Receipt getReceiptByReceiptId(int i) {
		Session su = hu.getSession();
		Receipt receipt = su.get(Receipt.class, i);
		su.close();
		return receipt;
	}

	@Override
	public List<Receipt> getAllReceipts() {
		Session s = hu.getSession();
		String query = "from com.revature.beans.Receipt";
		Query<Receipt> q = s.createQuery(query, Receipt.class);
		List<Receipt> receiptList = q.getResultList();
		s.close();
		return receiptList;
	}

	@Override
	public int deleteReceipt(Receipt receipt) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(receipt);
		tx.commit();
		s.close();
		return 1;
	}

	@Override
	public Receipt updateReceipt(Receipt receipt) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.update(receipt);
		tx.commit();
		s.close();
		return receipt;
	}

}

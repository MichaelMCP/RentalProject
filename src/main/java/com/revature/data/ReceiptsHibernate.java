package com.revature.data;

import java.util.List;


import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.Receipt;
import com.revature.beans.User;
import com.revature.util.HibernateUtil;

public class ReceiptsHibernate implements ReceiptsDao, HibernateSession {
	
	private Session session;

	@Override
	public Receipt createReceipt(Receipt receipt){
		int i = (Integer) session.save(receipt);
		return receipt;
	}

	@Override
	public List<Receipt> getReceiptByRenterId(int i) {
		
		String query = "from com.revature.beans.Receipt re where re.user.id=:renterId";
		Query<Receipt> q = session.createQuery(query);
		q.setParameter("renterId", i);
		return (List<Receipt>) q.uniqueResult();
	}

	@Override
	public List<Receipt> getReceiptByOwnerId(int i) {
		String query = "from com.revature.beans.Receipt re where re.owner.id=:ownerId";
		Query<Receipt> q = session.createQuery(query);
		q.setParameter("ownerId", i);
		return (List<Receipt>) q.uniqueResult();
	}

	@Override
	public Receipt getReceiptByReceiptId(int i) {
		Receipt receipt = (Receipt) session.get(Receipt.class, i);
		return receipt;
	}

	@Override
	public List<Receipt> getAllReceipts() {
		String query = "from com.revature.beans.Receipt";
		List<Receipt> receiptList = (List<Receipt>) session.createQuery(query).list();
		return receiptList;
	}

	@Override
	public void deleteReceipt(Receipt receipt) {
		session.delete(receipt);
	}

	@Override
	public Receipt updateReceipt(Receipt receipt) {
		session.update(receipt);
		return receipt;
	}

	@Override
	public void setSession(Session session) {
		this.session = session;
		
	}
}

package com.revature.data;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.beans.RentTransaction;

@Repository
public class RentTransactionHibernate implements RentTransactionDao, HibernateSession {

	private Session session;
	
	@Override
	public void setSession(Session session) {
		
		this.session = session;
	}
	@Override
	public RentTransaction createRentTransaction(RentTransaction rt) {
		int i = (Integer) session.save(rt);
		return rt;
	}

	@Override
	public RentTransaction getRentTransactionByRentTransactionId(int i) {
		RentTransaction rt = (RentTransaction) session.get(RentTransaction.class, i);
		return rt;
	}

	@Override
	public List<RentTransaction> getRentTransactionByOwnerId(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RentTransaction> getAllRentTransactions() {
		String query = "from com.revature.beans.RentTransactions";
		List<RentTransaction> rtList = (List<RentTransaction>) session.createQuery(query).list();
		return rtList;
	}

	@Override
	public void deleteRentTransaction(RentTransaction rt) {
		session.delete(rt);
	}

	@Override
	public RentTransaction updateRentTransaction(RentTransaction rt) {
		session.update(rt);
		return rt;
	}

}

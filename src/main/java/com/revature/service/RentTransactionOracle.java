package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.RentTransaction;
import com.revature.data.RentTransactionDao;

@Service
public class RentTransactionOracle implements RentTransactionService {
	
	@Autowired
	RentTransactionDao ud;
	@Override
	public RentTransaction registerRentTransaction(String startdate, String enddate, int renterId, int propId,
			int approval, int paymentinfoId) {
		RentTransaction nu = new RentTransaction(0, startdate,  enddate,  renterId,  propId, approval,  paymentinfoId );
		ud.createRentTransaction(nu);
		return nu;
	}

}

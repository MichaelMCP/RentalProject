package com.revature.service;

import com.revature.beans.RentTransaction;

public interface RentTransactionService {
	public RentTransaction registerRentTransaction(String startdate, String enddate, int renterId, int propId, int approval,
			int paymentinfoId);
}

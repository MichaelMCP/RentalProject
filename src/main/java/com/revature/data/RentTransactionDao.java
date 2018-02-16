package com.revature.data;

import java.util.List;

import com.revature.beans.RentTransaction;

public interface RentTransactionDao 
{
	public RentTransaction createRentTransaction(RentTransaction rt);
	
	public RentTransaction getRentTransactionByRentTransactionId(int i);
	
	public List<RentTransaction> getRentTransactionByOwnerId(int i);

	public List<RentTransaction>getAllRentTransactions();

	public void deleteRentTransaction(RentTransaction rt);
	
	public RentTransaction updateRentTransaction(RentTransaction rt);
}

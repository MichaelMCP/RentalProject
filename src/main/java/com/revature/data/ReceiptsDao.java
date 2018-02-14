package com.revature.data;

import java.util.List;

import com.revature.beans.Receipt;

public interface ReceiptsDao {
	
	public int createRecepit(Receipt receipt);
	
	public List<Receipt> getReceiptByRenterId(int i);
	
	public List<Receipt> getReceiptByOwnerId(int i);

	public Receipt getReceiptByReceiptId(int i);

	public List<Receipt>getAllReceipts();

	public int deleteReceipt(Receipt receipt);
	
	public Receipt updateReceipt(Receipt receipt);

}

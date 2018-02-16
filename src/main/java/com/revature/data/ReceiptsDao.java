package com.revature.data;

import java.util.List;

import com.revature.beans.Receipt;

public interface ReceiptsDao {
	
	public Receipt createReceipt(Receipt receipt);
	
	public List<Receipt> getReceiptByRenterId(int i);
	
	public List<Receipt> getReceiptByOwnerId(int i);

	public Receipt getReceiptByReceiptId(int i);

	public List<Receipt>getAllReceipts();

	public void deleteReceipt(Receipt receipt);
	
	public Receipt updateReceipt(Receipt receipt);

}

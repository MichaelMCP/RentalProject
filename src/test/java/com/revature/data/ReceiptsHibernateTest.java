package com.revature.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.revature.beans.Receipt;
import com.revature.beans.User;

public class ReceiptsHibernateTest {
	
	private static ReceiptsDao rd = new ReceiptsHibernate();
	private static UserDao ud = new UserHibernate();

	@Test
	public void testCreateReceipt() {
		
		
		Receipt r = new Receipt();
		r.setAmount(10);
		
		Receipt test = rd.createReceipt(r);
		assertEquals(r, test);
		rd.deleteReceipt(r);
	}
	
	@Test
	public void testGetReceiptByReceiptId() {
		Receipt r = new Receipt();
		r.setAmount(10);
		rd.createReceipt(r);
		
		Receipt test = rd.getReceiptByReceiptId(r.getReceiptId());
		assertEquals(r, test);
		rd.deleteReceipt(r);
	}
	
	@Test
	public void testGetReceiptByRenterId() {
		User u = new User();
		u.setRole(1);
		u.setEmail("test10@test.com");
		u.setFullName("Bob");
		u.setPass("123");
		ud.createUser(u);
		
		Receipt r = new Receipt();
		r.setAmount(10);
		r.setUser(u);
		rd.createReceipt(r);
		
		List<Receipt> test = rd.getReceiptByRenterId(r.getUser().getId());
		assertTrue(test.contains(r));
		rd.deleteReceipt(r);
	}
	
	@Test
	public void testGetReceiptByOwnerId() {
		User u = new User();
		u.setRole(1);
		u.setEmail("test10@test.com");
		u.setFullName("Bob");
		u.setPass("123");
		ud.createUser(u);
		
		Receipt r = new Receipt();
		r.setAmount(10);
		r.setOwner(u);
		rd.createReceipt(r);
		
		List<Receipt> test = rd.getReceiptByOwnerId(r.getOwner().getId());
		assertTrue(test.contains(r));
		rd.deleteReceipt(r);
	}
	
	@Test
	public void testGetAllReceipts() {
		Receipt r = new Receipt();
		r.setAmount(10);
		rd.createReceipt(r);
		
		List<Receipt> test = rd.getAllReceipts();
		assertTrue(test.contains(r));
		rd.deleteReceipt(r);
	}
	
	@Test
	public void testUpdateReceipt() {
		Receipt r = new Receipt();
		r.setAmount(10);
		rd.createReceipt(r);
		
		r.setAmount(20);
		Receipt test = rd.updateReceipt(r);
		rd.deleteReceipt(r);
		assertEquals(r, test);
	}

}

package com.revature.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.revature.beans.PaymentInfo;
import com.revature.beans.User;

public class PaymentInfoHibernateTest {
	
	PaymentInfoDao pd = new PaymentInfoHibernate();
	UserDao ud = new UserHibernate();

	@Test
	public void testCreatePaymentInfo() {
		
		User u = new User();
		u.setRole(1);
		u.setEmail("test@test.com");
		u.setFullName("Bob");
		u.setPassword("123");
		ud.createUser(u);
		
		PaymentInfo p = new PaymentInfo();
		p.setCost(10);
		p.setCreditCardNumber(1);
		p.setUser(u);
		
		int test = pd.createPaymentInfo(p);
		assertEquals(p.getId(), test);
	}

	@Test
	public void testGetPaymentInfoById() {
		User u = new User();
		u.setRole(1);
		u.setEmail("test2@test.com");
		u.setFullName("Bob");
		u.setPassword("123");
		ud.createUser(u);
		
		PaymentInfo p = new PaymentInfo();
		p.setCost(10);
		p.setCreditCardNumber(1);
		p.setUser(u);
		pd.createPaymentInfo(p);
		
		PaymentInfo test = pd.getPaymentInfoById(p.getId());
		assertEquals(p, test);
	}

	@Test
	public void testGetAllPaymentInfo() {
		User u = new User();
		u.setRole(1);
		u.setEmail("test3@test.com");
		u.setFullName("Bob");
		u.setPassword("123");
		ud.createUser(u);
		
		PaymentInfo p = new PaymentInfo();
		p.setCost(10);
		p.setCreditCardNumber(1);
		p.setUser(u);
		pd.createPaymentInfo(p);
		
		List<PaymentInfo> test = pd.getAllPaymentInfo();
		assertTrue(test.contains(p));
	}

	@Test
	public void testUpdatePaymentInfo() {
		User u = new User();
		u.setRole(1);
		u.setEmail("test4@test.com");
		u.setFullName("Bob");
		u.setPassword("123");
		ud.createUser(u);
		
		PaymentInfo p = new PaymentInfo();
		p.setCost(10);
		p.setCreditCardNumber(1);
		p.setUser(u);
		pd.createPaymentInfo(p);
		
		p.setCost(20);
		PaymentInfo test = pd.updatePaymentInfo(p);
		assertEquals(p, test);
	}

	@Test
	public void testDeletePaymentInfo() {
		User u = new User();
		u.setRole(1);
		u.setEmail("test5@test.com");
		u.setFullName("Bob");
		u.setPassword("123");
		ud.createUser(u);
		
		PaymentInfo p = new PaymentInfo();
		p.setCost(10);
		p.setCreditCardNumber(1);
		p.setUser(u);
		pd.createPaymentInfo(p);
		int test = pd.deletePaymentInfo(p);
		assertEquals(1, test);
	}

}
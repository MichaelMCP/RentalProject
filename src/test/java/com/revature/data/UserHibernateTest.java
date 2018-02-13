package com.revature.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.revature.beans.User;

public class UserHibernateTest {
	@Before
	public void setup() {
		ud= new UserHibernate();
	}
	private static UserDao ud;
	private static Logger log = Logger.getRootLogger();
	
	@Test
	public void testCreateUser() {
		User u = new User();
		u.setRole(1);
		u.setEmail("test@test.com");
		u.setFullName("Bob");
		u.setPassword("123");
		int test = ud.createUser(u);
		assertEquals(u.getId(), test);
		ud.deleteUser(u);
	}
	
	@Test
	public void testGetUser() {
		User u = new User();
		u.setRole(1);
		u.setEmail("test2@test.com");
		u.setFullName("Bob");
		u.setPassword("123");
		ud.createUser(u);
		User test = ud.getUserById(u.getId());
		assertEquals(u, test);
		ud.deleteUser(u);
	}
	
	@Test
	public void testUpdateUser() {
		User u = new User();
		u.setRole(1);
		u.setEmail("test3@test.com");
		u.setFullName("Bob");
		u.setPassword("123");
		ud.createUser(u);
		u.setFullName("Joe");
		User test = ud.updateUser(u);
		assertEquals(u, test);
		ud.deleteUser(u);
	}
	
	@Test
	public void testDeleteUser() {
		User u = new User();
		u.setRole(1);
		u.setEmail("test4@test.com");
		u.setFullName("Bob");
		u.setPassword("123");
		ud.createUser(u);
		int test = ud.deleteUser(u);
		assertEquals(1, test);
	}
	
	@Test
	public void testGetAllUsers() {
		User u = new User();
		u.setRole(1);
		u.setEmail("test5@test.com");
		u.setFullName("Bob");
		u.setPassword("123");
		ud.createUser(u);
		List<User> test = ud.getAllUsers();
		assertTrue(test.contains(u));
		ud.deleteUser(u);
	}
	
	@Test
	public void testGetUserLogin() {
		User u = new User();
		u.setRole(1);
		u.setEmail("test6@test.com");
		u.setFullName("Bob");
		u.setPassword("123");
		ud.createUser(u);

		log.trace(u);
		User test = ud.getUser(u.getEmail(), u.getPassword());
		assertEquals(u, test);
		ud.deleteUser(u);
	}

}

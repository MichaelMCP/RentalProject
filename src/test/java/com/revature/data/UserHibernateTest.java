package com.revature.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.revature.beans.User;

public class UserHibernateTest {
	//reset the database when testing
	UserDao ud = new UserHibernate();

	
	@Test
	public void testCreateUser() {
		User u = new User();
		u.setRole(1);
		u.setEmail("test@test.com");
		u.setFullName("Bob");
		u.setPassword("123");
		int test = ud.createUser(u);
		assertEquals(u.getId(), test);
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
	}

}

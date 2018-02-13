package com.revature.data;

import java.util.List;

import com.revature.beans.User;

public interface UserDao 
{
	/**
	 * Returns the id of a user object inserted into the database.
	 * 
	 * @param user the user object to be inserted
	 * @return the id of the user object inserted
	 */
	public int createUser(User user);
	
	/**
	 * returns a login object from the database
	 * 
	 * @param username the username of the user
	 * @param password the password of the user
	 * @return the user from the database that matches the username and password
	 */	
	public User getUser(String email, String password);
	/**
	 * returns a login object from the database
	 * 
	 * @param u previously created user object for updating with user information
	 * @return the user from the database that matches the username and password
	 */
	public User getUser(User u);
	/**
	 * returns a login object from the database
	 * 
	 * @param u previously created user object for updating with user information
	 * @return the user from the database that matches the username and password
	 */
	public User getUserById(int i);
	/**
	 * returns a List of all users from the database
	 * 
	 * @return all users in the database
	 */
	public List<User>getAllUsers();
	/**
	 * deletes a User from the database
	 * 
	 * @param user the User to be deleted
	 */
	public int deleteUser(User user);
	
	/**
	 * updates a User in the database
	 * 
	 * @param user the User to be updated
	 */
	public User updateUser(User user);
}

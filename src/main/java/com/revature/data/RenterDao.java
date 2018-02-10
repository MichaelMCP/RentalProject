package com.revature.data;

import java.util.Set;

import com.revature.beans.Renter;



public interface RenterDao 
{
	/**
	 * Inserts a renter into the database.
	 * 
	 * @param Reneter the Renter object to be inserted
	 */
	public void createRenter(Renter renter);
	
	/**
	 * returns a login object from the database
	 * 
	 * @param cust the Customer object created by our service to hold customer data
	 * @return the Customer from the database that matches the id,
	 * an empty customer object if no customer exists with that id.
	 */
	public Renter getCustomer(Renter renter);
	
	/**
	 * returns a list of all renters in database
	 * 
	 * @return list of renters in database
	 */
	public Set<Renter> getCustomers();
	
	/**
	 * deletes a Renter from the database
	 * 
	 * @param Renter the Renter to be deleted
	 */
	public void deleteCustomer(Renter customer);
	
	public void updateCustomer(Renter customer);
}


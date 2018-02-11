package com.revature.data;

import java.util.Set;

import com.revature.beans.Service;

public interface ServiceDao {
	
	/**
	 * returns a service object from the database
	 * 
	 * @param serv the service object holding the id of the service to be retrieved
	 * @return the Service from the database that matches the id,
	 * an empty object if no Service with said id exists.
	 */
	
	public Service getService(Service serv);
	
	/**
	 * returns a list of all Services in database
	 * 
	 * @return list of Services in database
	 */
	
	public Set<Service> getServices();

}

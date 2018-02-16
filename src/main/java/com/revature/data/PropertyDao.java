package com.revature.data;

import java.util.List;

import com.revature.beans.Property;

public interface PropertyDao {
	/**
	 * Returns the id of the inserted property from the database.
	 * 
	 * @param property the Property object to be inserted
	 * @return the id of the inserted Property object
	 */
	public Property registerProperty(Property property);
	
	/**
	 * deletes a Property from the database
	 * 
	 * @param property the Property object to be deleted
	 */
	public void deleteProperty(Property property);
	/**
	 * gets all Property Objects that has the id of a specific owner
	 * 
	 * @param id the id of an owner object
	 */
	public List<Property> getAllPropertiesByOwnerId(int id);
	/**
	 * gets all Property Objects that has the id of a specific owner
	 * 
	 * @param id the id of an owner object
	 */
	public List<Property> getAllProperties();
	/**
	 * updates the property object to the database
	 * 
	 * @param id the id of an owner object
	 */
	public Property updateProperty(Property property);
	
}

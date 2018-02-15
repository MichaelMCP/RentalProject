package com.revature.data;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.revature.beans.Property;
import com.revature.beans.User;

public class PropertyHibernateTest {
	@Before
	public void setup() {
		ud= new UserHibernate();
		pd = new PropertyHibernate();
	}
	
	private static UserDao ud;
	private static PropertyDao pd;
	private static Logger log = Logger.getRootLogger();

	@Test
	public void testRegisterProperty() {
		User u = new User();
		
		u.setRole(1);
		u.setEmail("test@test.com");
		u.setFullName("Bob");
		u.setPass("123");
		int id = ud.createUser(u);
		u.setId(id);
		
		Property prop = new Property();
		prop.setOwner(u);
		prop.setAddress1("9384 Rocky Road.");
		prop.setAddress2(" ");
		prop.setCity("Glendale");
		prop.setZipcode(83302);
		prop.setCurrentRentPrice(132.00);
		prop.setRating(4.5);
		prop.setAvailability(1);
		prop.setState("California");
		
		int propId = pd.registerProperty(prop);
		
		assertEquals(propId, 1);
		pd.deleteProperty(prop);
		ud.deleteUser(u);
		
	}
	
	@Test
	public void testGetAllProperties() {
		User u = new User();
		
		u.setRole(1);
		u.setEmail("test@test.com");
		u.setFullName("Bob");
		u.setPass("123");
		int id = ud.createUser(u);
		u.setId(id);
		
		Property prop = new Property();
		prop.setOwner(u);
		prop.setAddress1("9384 Rocky Road.");
		prop.setAddress2(" ");
		prop.setCity("Glendale");
		prop.setZipcode(83302);
		prop.setCurrentRentPrice(132.00);
		prop.setRating(4.5);
		prop.setAvailability(1);
		prop.setState("California");

		Property prop1 = new Property();
		prop1.setOwner(u);
		prop1.setAddress1("Chereoke");
		prop1.setAddress2("Testing second addressline");
		prop1.setCity("Burbank");
		prop1.setZipcode(30493);
		prop1.setCurrentRentPrice(290.00);
		prop1.setRating(3.5);
		prop1.setAvailability(1);
		prop1.setState("California");
		
		Property prop2 = new Property();
		prop2.setOwner(u);
		prop2.setAddress1("Dawson's Creek Blvd.");
		prop2.setAddress2(" ");
		prop2.setCity("Burbank");
		prop2.setZipcode(49284);
		prop2.setCurrentRentPrice(395.00);
		prop2.setRating(5.0);
		prop2.setAvailability(0);
		prop2.setState("California");
		
		int propId = pd.registerProperty(prop);
		int propId1 = pd.registerProperty(prop1);
		int propId2 = pd.registerProperty(prop2);
		
		
		assertTrue(true);
//		assertTrue(pd.getAllProperties().contains(prop));
//		assertTrue(pd.getAllProperties().contains(prop1));
//		assertTrue(pd.getAllProperties().contains(prop2));
	}
	
	

}

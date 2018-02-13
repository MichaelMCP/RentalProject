package com.revature.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Property;
import com.revature.util.HibernateUtil;

public class PropertyHibernate implements PropertyDao {
	private static Logger log = Logger.getLogger(UserHibernate.class);
	private static HibernateUtil hu = HibernateUtil.getInstance();
	
	public static void main(String[] args) {
		PropertyDao ph = new PropertyHibernate();
		Property prop = new Property();
		prop.setPropertyId(2);
		prop.setOwnerId(1);
		prop.setAddress1("9384 Rocky Road.");
		prop.setAddress2(" ");
		prop.setCity("Glendale");
		prop.setZipcode(83302);
		prop.setCurrentRentPrice(132.00);
		prop.setRating(4.5);
		
		System.out.println(ph.registerProperty(prop));
	}
	
	@Override
	public int registerProperty(Property property) {
		Session session = hu.getSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			log.warn("The user is: "+property);
			int i = (Integer) session.save(property);
			log.warn("Created user will have an id of "+i);
			log.warn("The user is: "+property);
			
			
			tx.commit();
			
			return property.getPropertyId();
			
		} catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
			return 0;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean deleteProperty(Property property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Property> getAllPropertiesByOwnerId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Property> getAllProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Property updateProperty(Property property) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.revature.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Property;
import com.revature.beans.User;
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
		try {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(property);
		tx.commit();
		s.close();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	@Override
	public List<Property> getAllPropertiesByOwnerId(int id) {
		Session s = hu.getSession();
		String hquery = "from com.revature.beans.User where id = " + id;
		Query<Property> q = s.createQuery(hquery, Property.class);
		List<Property> propertyList = q.getResultList();
		s.close();
		return propertyList;
	}

	@Override
	public List<Property> getAllProperties() {
		Session s = hu.getSession();
		String hquery = "from com.revature.beans.User";
		Query<Property> q = s.createQuery(hquery, Property.class);
		List<Property> propertyList = q.getResultList();
		s.close();
		return propertyList;
	}

	@Override
	public Property updateProperty(Property property) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.update(property);
		tx.commit();
		s.close();
		return property;
	}

}

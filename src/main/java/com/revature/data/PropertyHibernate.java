package com.revature.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.Property;
import com.revature.util.HibernateUtil;

public class PropertyHibernate implements PropertyDao {
	private static Logger log = Logger.getLogger(UserHibernate.class);
	@Autowired
	private static HibernateUtil hu;
	
	@Override
	public int registerProperty(Property property){
		Session session = hu.getSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			log.warn("The property is: "+property);
			int i = (Integer) session.save(property);
			log.warn("Created property will have an id of "+i);
			log.warn("The property is: "+property);
			
			
			tx.commit();
			
			return property.getPropertyId();
			
		} catch(Exception e) {
			log.error(e);
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
			log.trace(e);
			return false;
		}
		return true;

	}

	@Override
	public List<Property> getAllPropertiesByOwnerId(int id) {
		Session s = hu.getSession();
		String hquery = "from com.revature.beans.Property where owner_id = " + id;
		Query<Property> q = s.createQuery(hquery, Property.class);
		List<Property> propertyList = q.getResultList();
		s.close();
		return propertyList;
	}

	@Override
	public List<Property> getAllProperties() {
		Session s = hu.getSession();
		String hquery = "from com.revature.beans.Property";
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

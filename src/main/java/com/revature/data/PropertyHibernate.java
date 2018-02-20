package com.revature.data;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.beans.Property;

@Repository
public class PropertyHibernate implements PropertyDao, HibernateSession {
	private Session session;
	
	@Override
	public Property registerProperty(Property property){
		session.save(property);
		return property;
	}

	@Override
	public void deleteProperty(Property property) {
		session.delete(property);

	}

	@Override
	public List<Property> getAllPropertiesByOwnerId(int id) {
		String hquery = "from com.revature.beans.Property where owner_id = :owner_id";
		Query q = session.createQuery(hquery);
		q.setParameter("owner_id", id);
		return (List<Property>) q.getResultList();
	}
	
	@Override
	public List<Property> getAllPropertiesAvailable() {
		String hquery = "from com.revature.beans.Property where availability = :availability";
		Query q = session.createQuery(hquery);
		q.setParameter("availability", 1);
		return (List<Property>) q.getResultList();
	}

	@Override
	public List<Property> getAllProperties() {
		String hquery = "from com.revature.beans.Property";
		return (List<Property>) session.createQuery(hquery).list();
	}

	@Override
	public Property updateProperty(Property property) {
		session.update(property);
		return property;
	}

	@Override
	public void setSession(Session session) {
		this.session = session;
		
	}
}

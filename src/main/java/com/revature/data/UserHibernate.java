package com.revature.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.beans.User;

@Repository
public class UserHibernate implements UserDao, HibernateSession
{
	
	private Session session;

	@Override
	public User createUser(User user)
	{
		int i = (Integer) session.save(user);
		return user;

	}

	@Override
	public User getUser(String email, String pass) 
	{
		String query = "from com.revature.beans.User u where u.email=:email and u.pass=:pass";
		Query q = session.createQuery(query);
		q.setParameter("email", email);
		q.setParameter("pass", pass);
		return (User) q.uniqueResult();

	}
	
	@Override
	public User getUserById(int i) 
	{
		User u = (User) session.get(User.class, i);
		return u;
	}

	@Override
	public void deleteUser(User user) 
	{
		session.delete(user);
	}

	@Override
	public User updateUser(User user) 
	{
		session.update(user);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		
		String query = "from com.revature.beans.User";
		List<User> userList = (List<User>) session.createQuery(query).list();
		return userList;

	}

	@Override
	public void setSession(Session session) {
		
		this.session = session;
	}
}

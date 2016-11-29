package com.integration.dao;

import com.integration.entity.User;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {
 

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		String hsql="from User user order by user.userid asc";
		return (List<User>) this.getHibernateTemplate().find(hsql);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(user);
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		
		return this.getHibernateTemplate().get(User.class, id);
	}

	@Override
	public User loginUser(User user) {
		// TODO Auto-generated method stub
		String hsql="from User user where user.username='"+user.getUsername()+"' and user.password='"+user.getPassword()+"'";
		@SuppressWarnings("unchecked")
		List<User> users= (List<User>) this.getHibernateTemplate().find(hsql);
		if (users.size()>0) {
			return users.get(0);
		}
		return null;
	}
}

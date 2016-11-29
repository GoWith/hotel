package com.integration.dao;

import com.integration.entity.Order;
import com.integration.entity.User;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

public class OrderDAOImpl extends HibernateDaoSupport implements OrderDAO {

	public void saveOrder(Order ordr) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(ordr);
	}

	@SuppressWarnings("unchecked")
	public List<Order> findAllOrder() {
		// TODO Auto-generated method stub
		String hsql="from Order ord order by ord.orderid asc";
		return (List<Order>) this.getHibernateTemplate().find(hsql);
	}


	public void removeOrder(Order order) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(order);
	}


	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(order);
	}

	@Override
	public Order findOrderById(int id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Order.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Order> getUserOrder(User user) {
		// TODO Auto-generated method stub
		String hsql="from Order ord where ord.userid='"+user.getUserid()+"'";
		return (List<Order>) this.getHibernateTemplate().find(hsql);
	}

	@Override
	public List<Order> findOrderByUserdAndRoomid(int userid, int roomid) {
		// TODO Auto-generated method stub
		String hsql="from Order ord where ord.userid='"+userid+"' and ord.roomid='"+roomid+"'";
		return (List<Order>) this.getHibernateTemplate().find(hsql);
	}

}

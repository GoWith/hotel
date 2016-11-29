package com.integration.dao;

import com.integration.entity.Room;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

public class RoomDAOImpl extends HibernateDaoSupport implements RoomDAO {


	@Override
	public void saveRoom(Room room) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(room);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Room> findAllRoom() {
		// TODO Auto-generated method stub
		String hsql="from Room room order by room.roomid asc";
		return (List<Room>) this.getHibernateTemplate().find(hsql);
	}

	@Override
	public void removeRoom(Room room) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(room);
	}

	@Override
	public void updateRoom(Room room) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(room);
	}

	@Override
	public Room findRoomById(int id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Room.class, id);
	}

}

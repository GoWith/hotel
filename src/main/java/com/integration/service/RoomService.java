package com.integration.service;

import com.integration.entity.Room;

import java.util.List;

public interface RoomService {
	public void saveRoom(Room room);
	public List<Room> findAllRoom();
	public void removeRoom(Room room);
	public void updateRoom(Room room);
	public Room findRoomById(int id);
}

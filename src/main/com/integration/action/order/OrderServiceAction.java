package com.integration.action.order;

import com.integration.entity.Order;
import com.integration.entity.Room;
import com.integration.entity.User;
import com.integration.service.OrderService;
import com.integration.service.RoomService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderServiceAction extends ActionSupport {
	private Room room;
	private OrderService orderService;
	private RoomService roomService;
	private String message;
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public RoomService getRoomService() {
		return roomService;
	}
	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request= ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		List<Order> orders=this.orderService.getUserOrder(user);
		List<Room> rooms=new ArrayList<Room>();
		if(orders.size()>0){
			for(Order order:orders){
				rooms.add(this.roomService.findRoomById(order.getRoomid()));
				
			}
		}
		Map requestList=(Map) ActionContext.getContext().get("request");
		requestList.put("listUserRoom", rooms);
		return SUCCESS;
	}
	// �˶�
	public String delete() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// ɾ������
		List<Order> order = this.orderService.findOrderByUserdAndRoomid(user
				.getUserid(), room.getRoomid());
		this.orderService.removeOrder(order.get(0));
		// ���÷���Ϊ�գ��޿���
		Room roomUser = this.roomService.findRoomById(room.getRoomid());
		roomUser.setStatus(0);
		this.roomService.updateRoom(roomUser);
		message = "�˶�����ɹ���";
		return "delSuc";
	}
}

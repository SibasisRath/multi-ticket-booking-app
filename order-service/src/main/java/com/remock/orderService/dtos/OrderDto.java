package com.remock.orderService.dtos;

public class OrderDto {
	private String userId;
	private Object busBookedTickets;
	private Object trainBookedTickets;
	private Object hotelBookedRooms;
	
	public OrderDto() {
		
	}

	public OrderDto(String userId, Object busBookedTickets, Object trainBookedTickets, Object hotelBookedRooms) {
		this.userId = userId;
		this.busBookedTickets = busBookedTickets;
		this.trainBookedTickets = trainBookedTickets;
		this.hotelBookedRooms = hotelBookedRooms;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Object getBusBookedTickets() {
		return busBookedTickets;
	}

	public void setBusBookedTickets(Object busBookedTickets) {
		this.busBookedTickets = busBookedTickets;
	}

	public Object getTrainBookedTickets() {
		return trainBookedTickets;
	}

	public void setTrainBookedTickets(Object trainBookedTickets) {
		this.trainBookedTickets = trainBookedTickets;
	}

	public Object getHotelBookedRooms() {
		return hotelBookedRooms;
	}

	public void setHotelBookedRooms(Object hotelBookedRooms) {
		this.hotelBookedRooms = hotelBookedRooms;
	}

	
	

}

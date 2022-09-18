package com.remock.orderService.services;

import org.springframework.stereotype.Service;

import com.remock.orderService.dtos.OrderDto;

@Service
public class OrderService {

	
	  public OrderService() {
	  
	  }
	 

	public Object getOrderDetailsByIserId(String userId, Object bus, Object train, Object hotel) {
		OrderDto orderDto = new OrderDto();
		orderDto.setUserId(userId);
		orderDto.setBusBookedTickets(bus);
		orderDto.setTrainBookedTickets(train);
		orderDto.setHotelBookedRooms(hotel);
		return (orderDto);
	}

}

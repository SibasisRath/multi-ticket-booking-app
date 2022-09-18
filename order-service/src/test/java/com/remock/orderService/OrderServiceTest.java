package com.remock.orderService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.remock.orderService.dtos.OrderDto;
import com.remock.orderService.services.OrderService;

public class OrderServiceTest {

	OrderService orderService;

	@BeforeEach
	void setup() {
		orderService = new OrderService();
	}

	@DisplayName("Junit test for getting user order details.")

	@Test
	void testGetUserOrderDetails() throws Exception {
		OrderDto orderDto = new OrderDto("sss", "no this does not exist", "no this does not exist",
				"no this does not exist");
		Object object = orderService.getOrderDetailsByIserId(orderDto.getUserId(), orderDto.getBusBookedTickets(),
				orderDto.getTrainBookedTickets(), orderDto.getHotelBookedRooms());
		Assertions.assertThat(object).isNotNull();

	}

}

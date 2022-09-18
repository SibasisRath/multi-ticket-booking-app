package com.remock.orderService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.remock.orderService.services.OrderService;

import io.micrometer.core.annotation.Timed;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;
	@Autowired
	RestTemplate restTemplate;

	@GetMapping(path = "/order/{userid}")
	@Timed(value = "get_order")
	public Object getOrderDetails(@PathVariable("userid") String userId) {
		Object bus = restTemplate.getForObject("http://bus-service/bus/bookingslist/" + userId, Object.class);
		Object train = restTemplate.getForObject("http://train-service/train/getbookingalllist/" + userId,
				Object.class);
		Object hotel = restTemplate.getForObject("http://hotel-service/hotel/getbookingdetailslist/" + userId,
				Object.class);
		return ResponseEntity.ok(orderService.getOrderDetailsByIserId(userId, bus, train, hotel));
	}
}

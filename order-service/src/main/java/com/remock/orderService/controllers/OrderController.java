package com.remock.orderService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.remock.orderService.services.OrderService;

import io.micrometer.core.annotation.Timed;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;
	@Autowired
	RestTemplate restTemplate;

	@GetMapping(path = "/order/{userid}")
	@Timed(value = "get_order")
	public Object getOrderDetails(@PathVariable("userid") String userId) {
        String busurl = UriComponentsBuilder.fromHttpUrl("http://bus-service/bus/bookinglist/")
                .pathSegment(userId)
                .toUriString();
        String trainurl = UriComponentsBuilder.fromHttpUrl("http://train-service/train/getbookinglist/")
                .pathSegment(userId)
                .toUriString();
        String hotelurl = UriComponentsBuilder.fromHttpUrl("http://hotel-service/hotel/getbookingdetailslist/")
                .pathSegment(userId)
                .toUriString();
        Object bus = restTemplate.getForObject(busurl, Object.class);
		Object train = restTemplate.getForObject(trainurl,
				Object.class);
		Object hotel = restTemplate.getForObject(hotelurl,
				Object.class);
		return ResponseEntity.ok(orderService.getOrderDetailsByIserId(userId, bus, train, hotel));
	}
}

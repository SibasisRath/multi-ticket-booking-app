package com.remock.hotelService.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.remock.hotelService.services.HotelSearchService;

@RestController
public class HotelSearchController {
	private static final Logger log = LoggerFactory.getLogger(HotelSearchController.class);
	@Autowired
	private HotelSearchService hotelSearchService;

	@GetMapping(path = "/hotel/city/{city}")
	public Object getListOfHotels(@PathVariable("city") String city) {
		log.info("inside get list of hotels by city controller.");
		return ResponseEntity.ok(hotelSearchService.hotelsOfCity(city));
	}

	@GetMapping(path = "/hotel/hoteldetails/{hotelname}")
	public Object getHotelDetails(@PathVariable("hotelname") String hotelName) {
		log.info("inside get details of hotel controller.");
		return ResponseEntity.ok(hotelSearchService.hotelDetails(hotelName));

	}
}

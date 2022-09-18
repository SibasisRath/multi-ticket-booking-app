package com.remock.hotelService.controllers;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.remock.hotelService.dtos.HotelBookingsDto;
import com.remock.hotelService.services.HotelBookingsService;

@RestController
public class HotelBookingsController {
	private static final Logger log = LoggerFactory.getLogger(HotelBookingsController.class);
	@Autowired
	private HotelBookingsService bookingsService;

	@PostMapping(path = "/hotel/book/{hotel}/{checkindate}/{checkoutdate}/{userid}")
	public Object bookHotel(@PathVariable("hotel") String hotel, @PathVariable("checkindate") Date checkindate,
			@PathVariable("checkoutdate") Date checkoutdate, @PathVariable("userid") String userId,
			@RequestBody List<HotelBookingsDto> hotelBookingDtos) {
		log.info("inside book hotel controller.");
		return ResponseEntity
				.ok(bookingsService.bookHotelService(hotel, checkindate, checkoutdate, userId, hotelBookingDtos));
	}

	@GetMapping(path = "/hotel/getbookingdetails/{userid}/{checkindate}")
	public Object getBookingDetailsByDate(@PathVariable("userid") String userId,
			@PathVariable("checkindate") Date checkInDate) {
		return ResponseEntity.ok(bookingsService.getHotelBookingDetails(userId, checkInDate));
	}

	@GetMapping(path = "/hotel/getbookingdetailslist/{userid}")
	public Object getBookingDetailsList(@PathVariable("userid") String userId) {
		return ResponseEntity.ok(bookingsService.getHotelBookingDetailList(userId));
	}

}

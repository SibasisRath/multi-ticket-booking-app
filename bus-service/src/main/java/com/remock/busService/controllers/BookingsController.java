package com.remock.busService.controllers;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.remock.busService.dtos.BookingsDto;
import com.remock.busService.services.BookingsService;

import io.micrometer.core.annotation.Timed;

@RestController
public class BookingsController {
	private static final Logger log = LoggerFactory.getLogger(BookingsController.class);
	@Autowired
	BookingsService busBookingsService;

	@PostMapping(path = "/bus/bookings", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed(value = "book_bus_tickets")
	public ResponseEntity<String> bookTicket(@RequestBody BookingsDto dto) {
		log.info("inside book ticket controller.");
		return ResponseEntity.ok(busBookingsService.bookingTickets(dto));
	}

	@GetMapping(path = "/bus/bookings/{userid}/{dateFrom}")
	@Timed(value = "get_bus_booking_details_by_userId_datefrom")
	public Object getBookingDetails(@PathVariable("userid") String userId, @PathVariable("dateFrom") Date dateFrom) {
		log.info("inside get booking details controller by a specific date.");
		return ResponseEntity.ok(busBookingsService.gettingBookedDetails(userId, dateFrom));
	}

	@GetMapping(path = "/bus/bookingslist/{userId}")
	@Timed(value = "get_bus_bookings_list_by_userid")
	public Object getBookingList(@PathVariable("userId") String id) {
		log.info("inside get user list of all booked ticket controllers controller.");
		return ResponseEntity.ok(busBookingsService.gettingBusBookingList(id));
	}
}

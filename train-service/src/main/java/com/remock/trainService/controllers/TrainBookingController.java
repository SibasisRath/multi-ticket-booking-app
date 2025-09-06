package com.remock.trainService.controllers;

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

import com.remock.trainService.dtos.BookingsDto;
import com.remock.trainService.services.TrainBookingService;

import io.micrometer.core.annotation.Timed;

@RestController
public class TrainBookingController {
	private static final Logger log = LoggerFactory.getLogger(TrainBookingController.class);
	@Autowired
	TrainBookingService trainBookingService;

	@PostMapping(path = "/train/book/{userid}/{from}/{to}/{datefrom}/{train}/{berthname}")
	@Timed(value = "book_train")
	public Object bookTrainTicket(@PathVariable("userid") String userId, @PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("datefrom") Date dateFrom, @PathVariable("train") String trainName,
			@PathVariable("berthname") String berthName, @RequestBody List<BookingsDto> bookingsDtos) {
		log.info("inside book train ticket controller.");
		return ResponseEntity
				.ok(trainBookingService.bookingTrainTickets(userId, from, to, dateFrom, trainName, berthName, bookingsDtos));

	}

	@GetMapping(path = "/train/getbookinglist/{userid}/{datefrom}")
	@Timed(value = "get_train_booking_details")
	public Object getBookingList(@PathVariable("userid") String userId, @PathVariable("datefrom") Date dateFrom) {
		log.info("inside get booking list controller.");
		return trainBookingService.getUserBookingList(userId, dateFrom);

	}

	@GetMapping(path = "/train/getbookinglist/{userid}")
	@Timed(value = "get_train_booking_list")
	public Object getBookingAllList(@PathVariable("userid") String userId) {
		log.info("inside get booking list controller.");
		return trainBookingService.getUserBookingAllList(userId);

	}
}

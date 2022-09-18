package com.remock.busService.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.remock.busService.services.DetailsService;

import io.micrometer.core.annotation.Timed;

@RestController
public class DetailsController {
	private static final Logger log = LoggerFactory.getLogger(DetailsController.class);
	@Autowired
	DetailsService detailsService;

	@GetMapping(path = "/bus/sd/{source}/{destination}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed(value = "source_destination_search")
	public Object getDetails(@PathVariable("source") String source, @PathVariable("destination") String destination) {
		log.info("inside get details by source and destination controller.");
		return ResponseEntity.ok(detailsService.getingDetails(source, destination));

	}
}

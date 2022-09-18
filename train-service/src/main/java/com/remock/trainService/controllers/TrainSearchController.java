package com.remock.trainService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.remock.trainService.services.TrainSearchService;

@RestController
public class TrainSearchController {
	@Autowired
	TrainSearchService trainSearchService;

	@GetMapping(path = "/train/search/{source}/{destination}")
	public Object searchTrain(@PathVariable("source") String source, @PathVariable("destination") String destination) {
		return ResponseEntity.ok(trainSearchService.getTrainInfo(source, destination));

	}
}

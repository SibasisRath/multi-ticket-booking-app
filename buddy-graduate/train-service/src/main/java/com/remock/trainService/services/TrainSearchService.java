package com.remock.trainService.services;

import org.springframework.web.bind.annotation.RestController;

import com.remock.trainService.repositories.TrainRepository;

@RestController
public class TrainSearchService {
	TrainRepository trainRepository;

	public TrainSearchService(TrainRepository trainRepository) {
		this.trainRepository = trainRepository;
	}

	public Object getTrainInfo(String source, String destination) {
		if (trainRepository.checkSourceDestination(source, destination).size() == 0) {
			return ("{\"status\":\"This source and destination is not available.\"}");
		} else {
			return trainRepository.findBySourceDestination(source, destination);
		}

	}

}

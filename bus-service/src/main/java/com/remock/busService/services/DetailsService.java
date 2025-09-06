package com.remock.busService.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.remock.busService.repositories.BusSourceDestinationRepository;

@Service
public class DetailsService {
	private static final Logger log = LoggerFactory.getLogger(DetailsService.class);
	BusSourceDestinationRepository busSourceDestinationRepository;

	public DetailsService(BusSourceDestinationRepository busSourceDestinationRepository2) {
		this.busSourceDestinationRepository = busSourceDestinationRepository2;
	}

	public Object gettingDetails(String source, String destination) {
		log.info("inside getting details service class method.");
		if (busSourceDestinationRepository.findBySD(source, destination) == null) {
			return ("{\"status\":\"entered source and destination does not exist in this service.\"}");
		} else {
			return (busSourceDestinationRepository.findBySD(source, destination));
		}

	}
}

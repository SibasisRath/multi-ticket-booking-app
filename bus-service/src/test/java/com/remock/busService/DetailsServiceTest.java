package com.remock.busService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import com.remock.busService.entities.BusSourceDestination;
import com.remock.busService.repositories.BusSourceDestinationRepository;
import com.remock.busService.services.DetailsService;

public class DetailsServiceTest {
	BusSourceDestinationRepository busSourceDestinationRepository;
	DetailsService detailsService;

	@BeforeEach
	void setup() {
		busSourceDestinationRepository = Mockito.mock(BusSourceDestinationRepository.class);
		detailsService = new DetailsService(busSourceDestinationRepository);
	}

	@DisplayName("test getting bus details.")
	@Test
	void testGetBusDetails() throws Exception {
		BusSourceDestination busSourceDestination = new BusSourceDestination(1, "puri", "puri123");

		BDDMockito.given(busSourceDestinationRepository.findBySD(busSourceDestination.getSource(),
				busSourceDestination.getDestination())).willReturn(busSourceDestination);
		
		Object busDetails = detailsService.gettingDetails(busSourceDestination.getSource(),
				busSourceDestination.getDestination());
		
		Assertions.assertThat(busDetails).isNotNull();
	}
	
	@DisplayName("test getting bus details1.")
	@Test
	void testGetBusDetails1() throws Exception {
		BusSourceDestination busSourceDestination = new BusSourceDestination(1, "puri", "puri123");

		BDDMockito.given(busSourceDestinationRepository.findBySD(busSourceDestination.getSource(),
				busSourceDestination.getDestination())).willReturn(busSourceDestination);
		
		Object busDetails = detailsService.gettingDetails(busSourceDestination.getSource(),
				null);
		
		Assertions.assertThat(busDetails).isNotNull();
	}

}

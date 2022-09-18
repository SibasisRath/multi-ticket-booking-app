package com.remock.trainService;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import com.remock.trainService.entities.Train;
import com.remock.trainService.repositories.TrainRepository;
import com.remock.trainService.services.TrainSearchService;

public class TrainSearchServiceTest {
	TrainRepository trainRepository;
	TrainSearchService trainSearchService;

	@BeforeEach
	void setup() {
		trainRepository = Mockito.mock(TrainRepository.class);
		trainSearchService = new TrainSearchService(trainRepository);
	}

	@DisplayName("testing getTrainInfo.")
	@Test
	void testGetTrainInfo() throws Exception {
		Train train = new Train();
		train.setTrainId(1);
		train.setTrainName("train1");
		train.setBerthNames("3-tire ac");
		train.setSource("puri");
		train.setDestination("durg");
		List<Integer> integers = new ArrayList<>();

		BDDMockito.given(trainRepository.checkSourceDestination(train.getSource(), train.getDestination()))
				.willReturn(integers);

		Object object = trainSearchService.getTrainInfo("puri", "durg");
		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing getTrainInfo1.")
	@Test
	void testGetTrainInfo1() throws Exception {
		Train train = new Train();
		train.setTrainId(1);
		train.setTrainName("train1");
		train.setBerthNames("3-tire ac");
		train.setSource("puri");
		train.setDestination("durg");
		List<Integer> integers = new ArrayList<>();
		integers.add(1);

		BDDMockito.given(trainRepository.checkSourceDestination(train.getSource(), train.getDestination()))
				.willReturn(integers);
		BDDMockito.given(trainRepository.findBySourceDestination(train.getSource(), train.getDestination()))
				.willReturn(train);

		Object object = trainSearchService.getTrainInfo("puri", "durg");
		Assertions.assertThat(object).isNotNull();

	}
}

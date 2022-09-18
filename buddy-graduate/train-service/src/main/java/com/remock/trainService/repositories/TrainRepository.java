package com.remock.trainService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.remock.trainService.entities.Train;

@Repository
public interface TrainRepository extends JpaRepository<Train, Integer> {

	@Query(value = "select trainid trainid from Trains where source = ?1 and destination = ?2", nativeQuery = true)
	public List<Integer> checkSourceDestination(String source, String destination);

	@Query(value = "select * from trains where source = ?1 and destination = ?2", nativeQuery = true)
	public Train findBySourceDestination(String source, String destination);

	public boolean existsByTrainName(String trainName);

	@Query(value = "select * from trains where trainname = ?1", nativeQuery = true)
	public Train findByTrainName(String trainName);

	@Query(value = "select source from trains where trainname = ?1", nativeQuery = true)
	public String getSourceByTrain(String train);

	@Query(value = "select destination from trains where trainname = ?1", nativeQuery = true)
	public String getDestinationByTrain(String train);

}

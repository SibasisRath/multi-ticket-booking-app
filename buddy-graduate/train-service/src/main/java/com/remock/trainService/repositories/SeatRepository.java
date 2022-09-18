package com.remock.trainService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.remock.trainService.entities.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {

	@Query(value = "select seatnumber from seats where train_name = ?1 and berthname = ?2 and status = ?3", nativeQuery = true)
	List<String> findSeats(String trainName, String berthName, String status);

	@Query(value = "select * from seats where train_name = ?1 and berthname = ?2 and seatnumber = ?3", nativeQuery = true)
	Seat updateSeatStatus(String trainName, String berthName, String seatNo);

	@Query(value = "select * from seats where berthname = ?1 and train_name = ?2", nativeQuery = true)
	List<Seat> findByBerthName(String berthName, String trainName);

}

package com.remock.trainService.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.remock.trainService.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	@Query(value = "select * from bookings where userid = ?1", nativeQuery = true)
	List<Booking> findByUserId(String userId);

	@Query(value = "select * from bookings where userid = ?1 and datefrom = ?2", nativeQuery = true)
	List<Booking> findBookedSeatList(String userId, Date dateFrom);

}

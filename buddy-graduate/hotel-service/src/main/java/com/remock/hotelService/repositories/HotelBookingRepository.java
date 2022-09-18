package com.remock.hotelService.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.remock.hotelService.entities.HotelBooking;

@Repository
public interface HotelBookingRepository extends JpaRepository<HotelBooking, Integer> {

	boolean existsByUserId(String userId);

	@Query(value = "select checkindate from hotelbookings where userid = ?1", nativeQuery = true)
	List<Date> findCheckInDates(String userId);

	@Query(value = "select * from hotelbookings where userid = ?1 and checkindate = ?2", nativeQuery = true)
	List<HotelBooking> findUserBookingList(String userId, Date checkInDate);

	@Query(value = "select * from hotelbookings where userid = ?1", nativeQuery = true)
	List<HotelBooking> findByUserId(String userId);

	

}

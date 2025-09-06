package com.remock.busService.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.remock.busService.entities.Bookings;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Integer> {

	public List<Bookings> findByUserId(String id);

	@Query(value = "select * from bookings where userid = ?1 and datefrom = ?2", nativeQuery = true)
	public List<Bookings> findByUserIdAndDateFrom(String userId, LocalDate dateFrom);

}

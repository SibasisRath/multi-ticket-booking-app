package com.remock.busService.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.remock.busService.entities.BusStops;

@Repository
public interface BusStopsRepository extends JpaRepository<BusStops, Integer>{

	@Query(value = "select busstop from busstops where bus = ?1", nativeQuery = true)
	List<String> findBusStops(String bus);

	@Query(value = "select date from busstops where bus = ?1 and busstop = ?2", nativeQuery = true)
	Date getDate(String bus, String bpoint);

	@Query(value = "select bussd from busstops where busstop = ?1 and bus = ?2", nativeQuery = true)
	int getBusSD(String bpoint, String bus);

}

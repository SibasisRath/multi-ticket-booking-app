package com.remock.busService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.remock.busService.entities.BusSourceDestination;

@Repository
public interface BusSourceDestinationRepository extends JpaRepository<BusSourceDestination, Integer> {

	@Query(value = "select * from bussourcedestination where source = ?1 and destination = ?2", nativeQuery = true)
	BusSourceDestination findBySD(String source, String destination);

	@Query(value = "select * from bussourcedestination where sdid = ?1", nativeQuery = true)
	BusSourceDestination getBusSourceDestination(int busSD);

}

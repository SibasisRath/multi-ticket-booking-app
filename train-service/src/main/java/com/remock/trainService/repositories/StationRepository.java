package com.remock.trainService.repositories;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.remock.trainService.entities.Station;

@Repository
public interface StationRepository extends JpaRepository<Station, Integer>{

	@Query(value = "select stationname from stations where trainid = ?1", nativeQuery = true)
	List<String> findStationsByTrainId(int trainId);

	@Query(value = "select * from stations where trainid = ?1 and stationname = ?2", nativeQuery = true)
	Station findStation(int trainId, String from);

	@Query(value = "select time from stations where date = ?1 and stationname = ?2 and trainid = ?3", nativeQuery = true)
	Time findTime(Date dateFrom, String from, int trainId);

	@Query(value = "select date from stations where stationname = ?1 and trainid = ?2", nativeQuery = true)
	Date findReturnDate(String to, int trainId);

}

package com.remock.busService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.remock.busService.entities.BusVacancy;

@Repository
public interface BusVacancyRepository extends JpaRepository<BusVacancy, Integer> {

	@Query(value = "select vacancy vacancy from busvacancy where bus = ?1", nativeQuery = true)
	int checkBusVacancy(String bus);

	@Query(value = "select * from busvacancy where bus = ?1", nativeQuery = true)
	BusVacancy getByBus(String bus);
}

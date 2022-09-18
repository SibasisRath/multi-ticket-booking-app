package com.remock.hotelService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.remock.hotelService.entities.Vacancy;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Integer> {

	boolean existsByRoomType(String roomType);

	@Query(value = "select * from vacancy where roomtype = ?1 and cityhotel = ?2", nativeQuery = true)
	Vacancy getVacancy(String roomType, int hotelId);

}

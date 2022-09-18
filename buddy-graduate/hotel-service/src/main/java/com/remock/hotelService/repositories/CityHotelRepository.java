package com.remock.hotelService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.remock.hotelService.entities.CityHotel;

@Repository
public interface CityHotelRepository extends JpaRepository<CityHotel, Integer> {

	List<CityHotel> findByCity(String city);

	CityHotel findByHotelName(String hotelName);

	boolean existsByCity(String city);

	boolean existsByHotelName(String hotelName);

	@Query(value = "select id from hotels where hotelname = ?1" ,nativeQuery = true)
	int getIdByHotelName(String hotel);

}

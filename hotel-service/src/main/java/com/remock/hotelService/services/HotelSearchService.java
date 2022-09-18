package com.remock.hotelService.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.remock.hotelService.entities.CityHotel;
import com.remock.hotelService.repositories.CityHotelRepository;

@Service
public class HotelSearchService {
	private static final Logger log = LoggerFactory.getLogger(HotelSearchService.class);
	private CityHotelRepository cityHotelsRepository;

	public HotelSearchService(CityHotelRepository cityHotelRepository) {
		this.cityHotelsRepository = cityHotelRepository;
	}

	public Object hotelsOfCity(String city) {
		log.info("inside hotel find service by city name.");
		if (cityHotelsRepository.existsByCity(city)) {
			List<CityHotel> hotels = new ArrayList<>();
			hotels = cityHotelsRepository.findByCity(city);
			return hotels;
		} else {
			return ("{\"status\":\"entered city name does not exist in the database.\"}");
		}

	}

	public Object hotelDetails(String hotelName) {
		if (cityHotelsRepository.existsByHotelName(hotelName)) {
			log.info("inside hotel details service.");
			return cityHotelsRepository.findByHotelName(hotelName);
		} else {
			return ("{\"status\":\"entered hotel name does not exist in the database.\"}");
		}

	}
}

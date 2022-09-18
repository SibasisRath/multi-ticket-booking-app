package com.remock.hotelService;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import com.remock.hotelService.entities.CityHotel;
import com.remock.hotelService.repositories.CityHotelRepository;
import com.remock.hotelService.services.HotelSearchService;

public class HotelSearchServiceTest {

	CityHotelRepository cityHotelRepository;
	HotelSearchService hotelSearchService;

	@BeforeEach
	void setup() {
		cityHotelRepository = Mockito.mock(CityHotelRepository.class);
		hotelSearchService = new HotelSearchService(cityHotelRepository);
	}

	@DisplayName("test hotel search by city name.")
	@Test
	void testHotelsOfCity() throws Exception {
		CityHotel cityHotel = new CityHotel(1, "city", "hotelName", "facilities");
		List<CityHotel> cityHotels = new ArrayList<>();
		cityHotels.add(cityHotel);

		BDDMockito.given(cityHotelRepository.existsByCity(cityHotel.getCity())).willReturn(true);
		BDDMockito.given(cityHotelRepository.findByCity(cityHotel.getCity())).willReturn(cityHotels);

		Object object = hotelSearchService.hotelsOfCity(cityHotel.getCity());

		Assertions.assertThat(object).isNotNull();
	}
	
	@DisplayName("test hotel search by city name1.")
	@Test
	void testHotelsOfCity1() throws Exception {
		CityHotel cityHotel = new CityHotel(1, "city", "hotelName", "facilities");
		List<CityHotel> cityHotels = new ArrayList<>();
		cityHotels.add(cityHotel);

		BDDMockito.given(cityHotelRepository.existsByCity(cityHotel.getCity())).willReturn(false);

		Object object = hotelSearchService.hotelsOfCity(cityHotel.getCity());

		Assertions.assertThat(object).isNotNull();
	}
	
	@DisplayName("test hotel search by hotel name.")
	@Test
	void testHotelDetails() throws Exception {
		CityHotel cityHotel = new CityHotel(1, "city", "hotelName", "facilities");

		BDDMockito.given(cityHotelRepository.existsByHotelName("hotelName")).willReturn(true);
		BDDMockito.given(cityHotelRepository.findByHotelName("hotelName")).willReturn(cityHotel);

		Object object = hotelSearchService.hotelDetails("hotelName");

		Assertions.assertThat(object).isNotNull();
	}
	
	@DisplayName("test hotel search by hotel name1.")
	@Test
	void testHotelDetails1() throws Exception {
		CityHotel cityHotel = new CityHotel(1, "city", "hotelName", "facilities");

		BDDMockito.given(cityHotelRepository.existsByHotelName(cityHotel.getHotelName())).willReturn(false);
		
		Object object = hotelSearchService.hotelDetails(cityHotel.getHotelName());

		Assertions.assertThat(object).isNotNull();
	}

}

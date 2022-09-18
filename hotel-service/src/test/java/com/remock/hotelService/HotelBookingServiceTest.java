package com.remock.hotelService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import com.remock.hotelService.dtos.HotelBookingsDto;
import com.remock.hotelService.entities.HotelBooking;
import com.remock.hotelService.entities.Vacancy;
import com.remock.hotelService.repositories.CityHotelRepository;
import com.remock.hotelService.repositories.HotelBookingRepository;
import com.remock.hotelService.repositories.VacancyRepository;
import com.remock.hotelService.services.HotelBookingsService;

public class HotelBookingServiceTest {
	HotelBookingRepository hotelBookingRepository;
	CityHotelRepository cityHotelRepository;
	VacancyRepository vacancyRepository;
	HotelBookingsService hotelBookingsService;

	@BeforeEach
	void setip() {
		hotelBookingRepository = Mockito.mock(HotelBookingRepository.class);
		cityHotelRepository = Mockito.mock(CityHotelRepository.class);
		vacancyRepository = Mockito.mock(VacancyRepository.class);
		hotelBookingsService = new HotelBookingsService(hotelBookingRepository, cityHotelRepository, vacancyRepository);
	}

	@DisplayName("testing get hotel book list.")
	@Test
	void testGetHotelBookingDetailList() throws Exception {
		HotelBooking booking = new HotelBooking(1, "sss", "mayfare", "3-bed room", Date.valueOf("2020-11-12"),
				Date.valueOf("2020-11-14"), 3);

		List<HotelBooking> bookings = new ArrayList<>();
		bookings.add(booking);

		BDDMockito.given(hotelBookingRepository.findByUserId(booking.getUserId())).willReturn(bookings);

		Object object = hotelBookingsService.getHotelBookingDetailList(booking.getUserId());

		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing get hotel book list1.")
	@Test
	void testGetHotelBookingDetailList1() throws Exception {
		HotelBooking booking = new HotelBooking(1, "sss", "mayfare", "3-bed room", Date.valueOf("2020-11-12"),
				Date.valueOf("2020-11-14"), 3);

		List<HotelBooking> bookings = new ArrayList<>();

		BDDMockito.given(hotelBookingRepository.findByUserId("lala")).willReturn(bookings);

		Object object = hotelBookingsService.getHotelBookingDetailList(booking.getUserId());

		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing get hotel booking details.")
	@Test
	void testGetHotelBookingDetails() throws Exception {
		HotelBooking booking = new HotelBooking(1, "sss", "mayfare", "3-bed room", Date.valueOf("2020-11-12"),
				Date.valueOf("2020-11-14"), 3);

		List<HotelBooking> bookings = new ArrayList<>();
		bookings.add(booking);

		List<Date> dates = new ArrayList<>();
		dates.add(Date.valueOf("2020-11-12"));

		BDDMockito.given(hotelBookingRepository.existsByUserId(booking.getUserId())).willReturn(true);
		BDDMockito.given(hotelBookingRepository.findCheckInDates(booking.getUserId())).willReturn(dates);
		BDDMockito.given(hotelBookingRepository.findUserBookingList(booking.getUserId(), booking.getCheckInDate()))
				.willReturn(bookings);

		Object object = hotelBookingsService.getHotelBookingDetails(booking.getUserId(), booking.getCheckInDate());

		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing get hotel booking details1.")
	@Test
	void testGetHotelBookingDetails1() throws Exception {
		HotelBooking booking = new HotelBooking(1, "sss", "mayfare", "3-bed room", Date.valueOf("2020-11-12"),
				Date.valueOf("2020-11-14"), 3);

		List<HotelBooking> bookings = new ArrayList<>();

		List<Date> dates = new ArrayList<>();
		dates.add(Date.valueOf("2020-11-12"));

		BDDMockito.given(hotelBookingRepository.existsByUserId(booking.getUserId())).willReturn(true);
		BDDMockito.given(hotelBookingRepository.findCheckInDates(booking.getUserId())).willReturn(dates);
		BDDMockito.given(hotelBookingRepository.findUserBookingList("lala", Date.valueOf("2022-01-05")))
				.willReturn(bookings);

		Object object = hotelBookingsService.getHotelBookingDetails(booking.getUserId(), Date.valueOf("2011-01-01"));

		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing get hotel booking details2.")
	@Test
	void testGetHotelBookingDetails2() throws Exception {
		HotelBooking booking = new HotelBooking(1, "sss", "mayfare", "3-bed room", Date.valueOf("2020-11-12"),
				Date.valueOf("2020-11-14"), 3);

		List<Date> dates = new ArrayList<>();
		dates.add(Date.valueOf("2020-11-12"));

		BDDMockito.given(hotelBookingRepository.existsByUserId(booking.getUserId())).willReturn(false);

		Object object = hotelBookingsService.getHotelBookingDetails("lala", Date.valueOf("2012-12-12"));

		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing BookHotelService")
	@Test
	void testBookHotelService() throws Exception {
		List<HotelBookingsDto> hotelbookingDtos = new ArrayList<>();

		BDDMockito.given(cityHotelRepository.existsByHotelName("hellostay")).willReturn(false);

		Object object = hotelBookingsService.bookHotelService("hellostay", Date.valueOf("2012-12-12"),
				Date.valueOf("2012-12-14"), "sss", hotelbookingDtos);

		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing BookHotelService1")
	@Test
	void testBookHotelService1() throws Exception {
		List<HotelBookingsDto> hotelbookingDtos = new ArrayList<>();

		BDDMockito.given(cityHotelRepository.existsByHotelName("hellostay")).willReturn(true);

		Object object = hotelBookingsService.bookHotelService("hellostay", Date.valueOf("2012-12-12"),
				Date.valueOf("2012-12-10"), "sss", hotelbookingDtos);

		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing BookHotelService2")
	@Test
	void testBookHotelService2() throws Exception {
		HotelBookingsDto bookingDto = new HotelBookingsDto(1, "sss", "mayfare", null, Date.valueOf("2020-11-12"),
				Date.valueOf("2020-11-14"), 3);
		List<HotelBookingsDto> hotelbookingDtos = new ArrayList<>();
		hotelbookingDtos.add(bookingDto);

		BDDMockito.given(cityHotelRepository.existsByHotelName("hellostay")).willReturn(true);

		Object object = hotelBookingsService.bookHotelService("hellostay", Date.valueOf("2012-12-12"),
				Date.valueOf("2012-12-14"), "sss", hotelbookingDtos);

		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing BookHotelService3")
	@Test
	void testBookHotelService3() throws Exception {
		HotelBookingsDto bookingDto = new HotelBookingsDto(1, "sss", "mayfare", "3-bed room",
				Date.valueOf("2020-11-12"), Date.valueOf("2020-11-14"), 0);
		List<HotelBookingsDto> hotelbookingDtos = new ArrayList<>();
		hotelbookingDtos.add(bookingDto);

		BDDMockito.given(cityHotelRepository.existsByHotelName("hellostay")).willReturn(true);

		Object object = hotelBookingsService.bookHotelService("hellostay", Date.valueOf("2012-12-12"),
				Date.valueOf("2012-12-14"), "sss", hotelbookingDtos);

		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing BookHotelService4")
	@Test
	void testBookHotelService4() throws Exception {
		HotelBookingsDto bookingDto = new HotelBookingsDto(1, "sss", "mayfare", "3-bed room",
				Date.valueOf("2020-11-12"), Date.valueOf("2020-11-14"), 3);
		List<HotelBookingsDto> hotelbookingDtos = new ArrayList<>();
		hotelbookingDtos.add(bookingDto);

		BDDMockito.given(cityHotelRepository.existsByHotelName("hellostay")).willReturn(true);
		BDDMockito.given(vacancyRepository.existsByRoomType(bookingDto.getRoomType())).willReturn(false);

		Object object = hotelBookingsService.bookHotelService("hellostay", Date.valueOf("2012-12-12"),
				Date.valueOf("2012-12-14"), "sss", hotelbookingDtos);

		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing BookHotelService5")
	@Test
	void testBookHotelService5() throws Exception {
		HotelBookingsDto bookingDto = new HotelBookingsDto();
		bookingDto.setUserId("sss");
		bookingDto.setCheckInDate(Date.valueOf("2020-11-12"));
		bookingDto.setCheckOutDate(Date.valueOf("2020-11-14"));
		bookingDto.setPersons(6);
		bookingDto.setRoomType("3-bed room");
		bookingDto.setHbookingid(1);
		List<HotelBookingsDto> hotelbookingDtos = new ArrayList<>();
		hotelbookingDtos.add(bookingDto);

		BDDMockito.given(cityHotelRepository.existsByHotelName("hellostay")).willReturn(true);
		BDDMockito.given(vacancyRepository.existsByRoomType(bookingDto.getRoomType())).willReturn(true);

		Object object = hotelBookingsService.bookHotelService("hellostay", Date.valueOf("2012-12-12"),
				Date.valueOf("2012-12-14"), "sss", hotelbookingDtos);

		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing BookHotelService6")
	@Test
	void testBookHotelService6() throws Exception {
		HotelBookingsDto bookingDto = new HotelBookingsDto();
		bookingDto.setUserId("sss");
		bookingDto.setCheckInDate(Date.valueOf("2020-11-12"));
		bookingDto.setCheckOutDate(Date.valueOf("2020-11-14"));
		bookingDto.setPersons(6);
		bookingDto.setRoomType("2-bed room");
		bookingDto.setHbookingid(1);
		List<HotelBookingsDto> hotelbookingDtos = new ArrayList<>();
		hotelbookingDtos.add(bookingDto);

		BDDMockito.given(cityHotelRepository.existsByHotelName("hellostay")).willReturn(true);
		BDDMockito.given(vacancyRepository.existsByRoomType(bookingDto.getRoomType())).willReturn(true);

		Object object = hotelBookingsService.bookHotelService("hellostay", Date.valueOf("2012-12-12"),
				Date.valueOf("2012-12-14"), "sss", hotelbookingDtos);

		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing BookHotelService7")
	@Test
	void testBookHotelService7() throws Exception {
		HotelBookingsDto bookingDto = new HotelBookingsDto();
		bookingDto.setUserId("sss");
		bookingDto.setCheckInDate(Date.valueOf("2020-11-12"));
		bookingDto.setCheckOutDate(Date.valueOf("2020-11-14"));
		bookingDto.setPersons(6);
		bookingDto.setRoomType("1-bed room");
		bookingDto.setHbookingid(1);
		List<HotelBookingsDto> hotelbookingDtos = new ArrayList<>();
		hotelbookingDtos.add(bookingDto);

		BDDMockito.given(cityHotelRepository.existsByHotelName("hellostay")).willReturn(true);
		BDDMockito.given(vacancyRepository.existsByRoomType(bookingDto.getRoomType())).willReturn(true);

		Object object = hotelBookingsService.bookHotelService("hellostay", Date.valueOf("2012-12-12"),
				Date.valueOf("2012-12-14"), "sss", hotelbookingDtos);

		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing BookHotelService8")
	@Test
	void testBookHotelService8() throws Exception {
		HotelBookingsDto bookingDto = new HotelBookingsDto(1, "sss", "hellostay", "3-bed room",
				Date.valueOf("2020-11-12"), Date.valueOf("2020-11-14"), 2);
		List<HotelBookingsDto> hotelbookingDtos = new ArrayList<>();
		hotelbookingDtos.add(bookingDto);

		Vacancy vacancy = new Vacancy();
		vacancy.setId(1);
		vacancy.setRoomType("3-bed room");
		vacancy.setAvailableRooms(10);

		BDDMockito.given(cityHotelRepository.existsByHotelName("hellostay")).willReturn(true);
		BDDMockito.given(vacancyRepository.existsByRoomType(bookingDto.getRoomType())).willReturn(true);
		BDDMockito.given(cityHotelRepository.getIdByHotelName("hellostay")).willReturn(1);
		BDDMockito.given(vacancyRepository.getVacancy("3-bed room", 1)).willReturn(vacancy);

		Object object = hotelBookingsService.bookHotelService("hellostay", Date.valueOf("2012-12-12"),
				Date.valueOf("2012-12-14"), "sss", hotelbookingDtos);

		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing BookHotelService9")
	@Test
	void testBookHotelService9() throws Exception {
		HotelBookingsDto bookingDto = new HotelBookingsDto(1, "sss", "hellostay", "3-bed room",
				Date.valueOf("2020-11-12"), Date.valueOf("2020-11-14"), 2);
		List<HotelBookingsDto> hotelbookingDtos = new ArrayList<>();
		hotelbookingDtos.add(bookingDto);

		Vacancy vacancy = new Vacancy();
		vacancy.setId(1);
		vacancy.setRoomType("3-bed room");
		vacancy.setAvailableRooms(0);

		BDDMockito.given(cityHotelRepository.existsByHotelName("hellostay")).willReturn(true);
		BDDMockito.given(vacancyRepository.existsByRoomType(bookingDto.getRoomType())).willReturn(true);
		BDDMockito.given(cityHotelRepository.getIdByHotelName("hellostay")).willReturn(1);
		BDDMockito.given(vacancyRepository.getVacancy("3-bed room", 1)).willReturn(vacancy);

		Object object = hotelBookingsService.bookHotelService("hellostay", Date.valueOf("2012-12-12"),
				Date.valueOf("2012-12-14"), "sss", hotelbookingDtos);

		Assertions.assertThat(object).isNotNull();

	}

}

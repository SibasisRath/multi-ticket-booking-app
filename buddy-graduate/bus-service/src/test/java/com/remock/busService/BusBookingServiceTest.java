package com.remock.busService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import com.remock.busService.dtos.BookingsDto;
import com.remock.busService.entities.Bookings;
import com.remock.busService.entities.BusSourceDestination;
import com.remock.busService.entities.BusStops;
import com.remock.busService.entities.BusVacancy;
import com.remock.busService.repositories.BookingsRepository;
import com.remock.busService.repositories.BusSourceDestinationRepository;
import com.remock.busService.repositories.BusStopsRepository;
import com.remock.busService.repositories.BusVacancyRepository;
import com.remock.busService.services.BookingsService;

public class BusBookingServiceTest {
	BookingsRepository bookingsRepository;
	BusVacancyRepository busVacancyRepository;
	BusSourceDestinationRepository busSourceDestinationRepository;
	BusStopsRepository busStopsRepository;
	BookingsService bookingsService;

	@BeforeEach
	void setup() {
		bookingsRepository = Mockito.mock(BookingsRepository.class);
		busVacancyRepository = Mockito.mock(BusVacancyRepository.class);
		busSourceDestinationRepository = Mockito.mock(BusSourceDestinationRepository.class);
		busStopsRepository = Mockito.mock(BusStopsRepository.class);
		bookingsService = new BookingsService(bookingsRepository, busVacancyRepository, busSourceDestinationRepository,
				busStopsRepository);

	}

	@DisplayName("testing get bus booking details list service.")
	@Test
	void testGettingBusBookingList() throws Exception {
		Bookings booking = new Bookings(1, "userId", "asca", "asas", "asas", "asas", "asasa", null, null, 5);
		List<Bookings> busBooking = new ArrayList<>();
		busBooking.add(booking);

		BDDMockito.given(bookingsRepository.findByUserId("userId")).willReturn(busBooking);

		Object busBookingDetails = bookingsService.gettingBusBookingList("userId");

		Assertions.assertThat(busBookingDetails).isNotNull();
	}

	@DisplayName("testing get bus booking details list service1.")
	@Test
	void testGettingBusBookingList1() throws Exception {
		Bookings booking = new Bookings(1, "userId", "asca", "asas", "asas", "asas", "asasa", null, null, 5);
		List<Bookings> busBooking = new ArrayList<>();
		busBooking.add(booking);

		BDDMockito.given(bookingsRepository.findByUserId("user")).willReturn(busBooking);

		Object busBookingDetails = bookingsService.gettingBusBookingList("userId");

		Assertions.assertThat(busBookingDetails).isNotNull();
	}

	@DisplayName("testing get bus booking details service.")
	@Test
	void testGettingBookedDetails() throws Exception {
		Bookings booking = new Bookings(1, "user", "bus1", "puri", "bbsr", "stop1", "stop3", Date.valueOf("2022-10-12"),
				Date.valueOf("2022-10-14"), 3);
		List<Bookings> bookings = new ArrayList<>();
		bookings.add(booking);

		BDDMockito.given(bookingsRepository.findByBus(booking.getUserId(), booking.getDateFrom())).willReturn(bookings);

		Object busBookingDetails = bookingsService.gettingBookedDetails(booking.getUserId(), booking.getDateFrom());

		Assertions.assertThat(busBookingDetails).isNotNull();
	}

	@DisplayName("testing get bus booking details1 service.")
	@Test
	void testGettingBookedDetails1() throws Exception {
		Bookings booking = new Bookings(1, "user", "bus1", "puri", "bbsr", "stop1", "stop3", Date.valueOf("2022-10-12"),
				Date.valueOf("2022-10-14"), 3);
		List<Bookings> bookings = new ArrayList<>();
		bookings.add(booking);

		BDDMockito.given(bookingsRepository.findByBus("lsls", booking.getDateFrom())).willReturn(null);

		Object busBookingDetails = bookingsService.gettingBookedDetails("lsls", booking.getDateFrom());

		Assertions.assertThat(busBookingDetails).isNotNull();
	}

	@DisplayName("testing book bus tickets service.")
	@Test
	void testBookingTickets() throws Exception {
		Bookings booking = new Bookings(1, "user", "bus1", "puri", "bbsr", "stop1", "stop3", Date.valueOf("2022-10-12"),
				Date.valueOf("2022-10-14"), 3);
		List<Bookings> bookings = new ArrayList<>();
		bookings.add(booking);

		Object busBookingDetails = bookingsService.bookingTickets(new BookingsDto(1, null, "bus1", "puri", "bbsr",
				"stop1", "stop3", Date.valueOf("2022-10-12"), Date.valueOf("2022-10-14"), 1));

		Assertions.assertThat(busBookingDetails).isNotNull();
	}

	@DisplayName("testing book bus tickets service1.")
	@Test
	void testBookingTickets1() throws Exception {
		Bookings booking = new Bookings(1, "user", "bus1", "puri", "bbsr", "stop1", "stop3", Date.valueOf("2022-10-12"),
				Date.valueOf("2022-10-14"), 3);
		List<Bookings> bookings = new ArrayList<>();
		bookings.add(booking);

		Object busBookingDetails = bookingsService.bookingTickets(new BookingsDto(1, "user", "bus1", "puri", "bbsr",
				null, "stop3", Date.valueOf("2022-10-12"), Date.valueOf("2022-10-14"), 1));

		Assertions.assertThat(busBookingDetails).isNotNull();
	}

	@DisplayName("testing book bus tickets service2.")
	@Test
	void testBookingTickets2() throws Exception {
		Bookings booking = new Bookings(1, "user", "bus1", "puri", "bbsr", "stop1", "stop3", Date.valueOf("2022-10-12"),
				Date.valueOf("2022-10-14"), 3);
		List<Bookings> bookings = new ArrayList<>();
		bookings.add(booking);

		Object busBookingDetails = bookingsService.bookingTickets(new BookingsDto(1, "user", null, "puri", "bbsr",
				"stop1", "stop3", Date.valueOf("2022-10-12"), Date.valueOf("2022-10-14"), 1));

		Assertions.assertThat(busBookingDetails).isNotNull();
	}

	@DisplayName("testing book bus tickets service3.")
	@Test
	void testBookingTickets3() throws Exception {
		Bookings booking = new Bookings(1, "user", "bus1", "puri", "bbsr", "stop1", "stop3", Date.valueOf("2022-10-12"),
				Date.valueOf("2022-10-14"), 3);

		List<Bookings> bookings = new ArrayList<>();
		bookings.add(booking);

		Object busBookingDetails = bookingsService.bookingTickets(new BookingsDto(1, "user", "bus1", "puri", "bbsr",
				"stop1", "stop3", null, Date.valueOf("2022-10-14"), 1));

		Assertions.assertThat(busBookingDetails).isNotNull();
	}

	@DisplayName("testing book bus tickets service5.")

	@Test
	void testBookingTickets5() throws Exception {
		BookingsDto bookingsDto = new BookingsDto(1, "user", "bus1", "puri", "bbsr", "stop1", null,
				Date.valueOf("2022-10-12"), Date.valueOf("2022-10-14"), 1);
		Bookings booking = new Bookings(1, "user", "bus1", "puri", "bbsr", "stop1", "stop3", Date.valueOf("2022-10-12"),
				Date.valueOf("2022-10-14"), 3);

		List<Bookings> bookings = new ArrayList<>();
		bookings.add(booking);

		Object busBookingDetails = bookingsService.bookingTickets(bookingsDto);

		Assertions.assertThat(busBookingDetails).isNotNull();
	}

	@DisplayName("testing book bus tickets service4.")

	@Test
	void testBookingTickets4() throws Exception {
		BookingsDto bookingsDto = new BookingsDto(1, "user", "bus1", "puri", "bbsr", "stop1", "stop3",
				Date.valueOf("2022-10-12"), Date.valueOf("2022-10-14"), 0);

		Object busBookingDetails = bookingsService.bookingTickets(bookingsDto);

		Assertions.assertThat(busBookingDetails).isNotNull();
	}

	@DisplayName("testing book bus tickets service6.")

	@Test
	void testBookingTickets6() throws Exception {
		BookingsDto bookingsDto = new BookingsDto(1, "user", "bus1", "puri", "bbsr", "stop1", "stop3",
				Date.valueOf("2022-10-12"), Date.valueOf("2022-10-14"), 3);
		BDDMockito.given(busVacancyRepository.checkBusVacancy(bookingsDto.getBus())).willReturn(2);

		Object busBookingDetails = bookingsService.bookingTickets(bookingsDto);

		Assertions.assertThat(busBookingDetails).isNotNull();
	}

	@DisplayName("testing book bus tickets service7.")

	@Test
	void testBookingTickets7() throws Exception {
		BookingsDto bookingsDto = new BookingsDto(1, "user", "bus1", "puri", "bbsr", "stop1", "stop3",
				Date.valueOf("2022-10-12"), Date.valueOf("2022-10-14"), 3);
		BusStops busStops = new BusStops(1, "bus1", "stop1", "puri", Date.valueOf("2022-10-21"));

		BDDMockito.given(busVacancyRepository.checkBusVacancy(bookingsDto.getBus())).willReturn(20);
		BDDMockito.given(busStopsRepository.getDate(bookingsDto.getBus(), bookingsDto.getBpoint()))
				.willReturn(busStops.getDate());

		Object busBookingDetails = bookingsService.bookingTickets(bookingsDto);

		Assertions.assertThat(busBookingDetails).isNotNull();
	}

	@DisplayName("testing book bus tickets service8.")

	@Test
	void testBookingTickets8() throws Exception {
		BookingsDto bookingsDto = new BookingsDto(1, "user", "bus1", "puri", "bbsr", "stop1", "stop3",
				Date.valueOf("2022-10-12"), Date.valueOf("2022-10-14"), 3);
		BusStops busStop = new BusStops(1, "bus1", "stop1", "puri", Date.valueOf("2022-10-12"));
		List<String> busStops = new ArrayList<>();
		busStops.add("a");

		BDDMockito.given(busVacancyRepository.checkBusVacancy(bookingsDto.getBus())).willReturn(20);
		BDDMockito.given(busStopsRepository.getDate(bookingsDto.getBus(), bookingsDto.getBpoint()))
				.willReturn(busStop.getDate());
		BDDMockito.given(busStopsRepository.findBusStops(bookingsDto.getBus())).willReturn(busStops);

		Object busBookingDetails = bookingsService.bookingTickets(bookingsDto);

		Assertions.assertThat(busBookingDetails).isNotNull();
	}

	@DisplayName("testing book bus tickets service9.")

	@Test
	void testBookingTickets9() throws Exception {
		BookingsDto bookingsDto = new BookingsDto(1, "user", "bus1", "puri", "bbsr", "stop1", "stop3",
				Date.valueOf("2022-10-12"), Date.valueOf("2022-10-14"), 3);
		BusStops busStop = new BusStops(1, "bus1", "stop1", "puri", Date.valueOf("2022-10-12"));
		List<String> busStops = new ArrayList<>();
		busStops.add("stop1");

		BDDMockito.given(busVacancyRepository.checkBusVacancy(bookingsDto.getBus())).willReturn(20);
		BDDMockito.given(busStopsRepository.getDate(bookingsDto.getBus(), bookingsDto.getBpoint()))
				.willReturn(busStop.getDate());
		BDDMockito.given(busStopsRepository.findBusStops(bookingsDto.getBus())).willReturn(busStops);

		Object busBookingDetails = bookingsService.bookingTickets(bookingsDto);

		Assertions.assertThat(busBookingDetails).isNotNull();
	}

	@DisplayName("testing book bus tickets service10.")

	@Test
	void testBookingTickets10() throws Exception {
		BookingsDto bookingsDto = new BookingsDto(1, "user", "bus1", "puri", "bbsr", "stop1", "stop3",
				Date.valueOf("2022-10-12"), Date.valueOf("2022-10-14"), 3);
		BusStops busStop = new BusStops(1, "bus1", "stop1", "puri", Date.valueOf("2022-10-12"));
		List<String> busStops = new ArrayList<>();
		busStops.add("stop3");
		busStops.add("stop1");

		BDDMockito.given(busVacancyRepository.checkBusVacancy(bookingsDto.getBus())).willReturn(20);
		BDDMockito.given(busStopsRepository.getDate(bookingsDto.getBus(), bookingsDto.getBpoint()))
				.willReturn(busStop.getDate());
		BDDMockito.given(busStopsRepository.findBusStops(bookingsDto.getBus())).willReturn(busStops);

		Object busBookingDetails = bookingsService.bookingTickets(bookingsDto);

		Assertions.assertThat(busBookingDetails).isNotNull();
	}

	@DisplayName("testing book bus tickets service11.")

	@Test
	void testBookingTickets11() throws Exception {
		BookingsDto bookingsDto = new BookingsDto(1, "user", "bus1", "puri", "bbsr", "stop1", "stop3",
				Date.valueOf("2022-10-12"), Date.valueOf("2022-10-14"), 3);
		Bookings bookings = new Bookings(1, "user", "bus1", "puri", "bbsr", "stop1", "stop3",
				Date.valueOf("2022-10-12"), Date.valueOf("2022-10-14"), 3);
		BusStops busStop = new BusStops(1, "bus1", "stop1", "puri", Date.valueOf("2022-10-12"));
		List<String> busStops = new ArrayList<>();
		busStops.add("stop1");
		busStops.add("stop3");

		BusSourceDestination busSourceDestination = new BusSourceDestination(1, "puri", "bbsr");
		BusVacancy busVacancy = new BusVacancy("bus1", 20);

		BDDMockito.given(busVacancyRepository.checkBusVacancy(bookingsDto.getBus())).willReturn(20);
		BDDMockito.given(busStopsRepository.getDate(bookingsDto.getBus(), bookingsDto.getBpoint()))
				.willReturn(busStop.getDate());
		BDDMockito.given(busStopsRepository.findBusStops(bookingsDto.getBus())).willReturn(busStops);
		BDDMockito.given(busStopsRepository.getBusSD(bookingsDto.getBpoint(), bookingsDto.getBus())).willReturn(1);
		BDDMockito.given(busSourceDestinationRepository.getBusSourceDestination(1)).willReturn(busSourceDestination);
		BDDMockito.given(busStopsRepository.getDate(bookingsDto.getBus(), bookingsDto.getDpoint()))
				.willReturn(Date.valueOf("2022-10-14"));
		BDDMockito.given(bookingsRepository.save(bookings)).willReturn(bookings);
		BDDMockito.given(busVacancyRepository.getByBus(bookings.getBus())).willReturn(busVacancy);
		busVacancy.setVacancy(busVacancy.getVacancy() - bookingsDto.getSeats());
		BDDMockito.given(busVacancyRepository.save(busVacancy)).willReturn(busVacancy);

		Object busBookingDetails = bookingsService.bookingTickets(bookingsDto);

		Assertions.assertThat(busBookingDetails).isNotNull();
	}

}

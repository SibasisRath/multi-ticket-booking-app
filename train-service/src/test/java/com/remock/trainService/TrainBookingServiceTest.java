package com.remock.trainService;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import com.remock.trainService.dtos.BookingsDto;
import com.remock.trainService.entities.Booking;
import com.remock.trainService.entities.Seat;
import com.remock.trainService.entities.Station;
import com.remock.trainService.entities.Train;
import com.remock.trainService.repositories.BookingRepository;
import com.remock.trainService.repositories.SeatRepository;
import com.remock.trainService.repositories.StationRepository;
import com.remock.trainService.repositories.TrainRepository;
import com.remock.trainService.services.TrainBookingService;

public class TrainBookingServiceTest {
	BookingRepository trainBookingRepository;
	TrainRepository trainRepository;
	StationRepository stationRepository;
	SeatRepository seatRepository;
	TrainBookingService trainBookingService;

	@BeforeEach
	void setup() {
		trainBookingRepository = Mockito.mock(BookingRepository.class);
		trainRepository = Mockito.mock(TrainRepository.class);
		stationRepository = Mockito.mock(StationRepository.class);
		seatRepository = Mockito.mock(SeatRepository.class);
		trainBookingService = new TrainBookingService(trainBookingRepository, trainRepository, stationRepository,
				seatRepository);
	}

	@DisplayName("testing getUserBookingAllList")
	@Test
	void testGetUserBookingAllList() throws Exception {
		List<Booking> bookings = new ArrayList<>();

		BDDMockito.given(trainBookingRepository.findByUserId("lalaa")).willReturn(bookings);
		Object object = trainBookingService.getUserBookingAllList("user");
		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing getUserBookingAllList1")
	@Test
	void testGetUserBookingAllList1() throws Exception {
		Booking booking = new Booking(1, "puri", "durg", "train1", "station1", Date.valueOf("2020-11-11"),
				Time.valueOf("12:22:00"), "station3", Date.valueOf("2020-11-14"), Time.valueOf("12:00:00"), "user",
				"name", 23, "male", "3-tire ac", "123321");
		List<Booking> bookings = new ArrayList<>();
		bookings.add(booking);
		BDDMockito.given(trainBookingRepository.findByUserId(booking.getUserId())).willReturn(bookings);
		Object object = trainBookingService.getUserBookingAllList("user");
		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing getUserBookingList")
	@Test
	void testGetUserBookingList() throws Exception {
		Booking booking = new Booking(1, "puri", "durg", "train1", "station1", Date.valueOf("2020-11-11"),
				Time.valueOf("12:22:00"), "station3", Date.valueOf("2020-11-14"), Time.valueOf("12:00:00"), "user",
				"name", 23, "male", "3-tire ac", "123321");
		List<Booking> bookings = new ArrayList<>();
		bookings.add(booking);
		BDDMockito.given(trainBookingRepository.findBookedSeatList(booking.getUserId(), booking.getDateFrom()))
				.willReturn(bookings);
		Object object = trainBookingService.getUserBookingList("user", Date.valueOf("2020-11-11"));
		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing getUserBookingList1")
	@Test
	void testGetUserBookingList1() throws Exception {
		Booking booking = new Booking(1, "puri", "durg", "train1", "station1", Date.valueOf("2020-11-11"),
				Time.valueOf("12:22:00"), "station3", Date.valueOf("2020-11-14"), Time.valueOf("12:00:00"), "user",
				"name", 23, "male", "3-tire ac", "123321");
		List<Booking> bookings = new ArrayList<>();
		bookings.add(booking);
		BDDMockito.given(trainBookingRepository.findBookedSeatList("lala", Date.valueOf("1222-11-11")))
				.willReturn(bookings);
		Object object = trainBookingService.getUserBookingList("userss", Date.valueOf("2020-11-18"));
		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing bookingTrainTickets")
	@Test
	void testBookingTrainTickets() throws Exception {
		Booking booking = new Booking(1, "puri", "durg", "train1", "station1", Date.valueOf("2020-11-11"),
				Time.valueOf("12:22:00"), "station3", Date.valueOf("2020-11-14"), Time.valueOf("12:00:00"), "user",
				"name", 23, "male", "3-tire ac", "123321");
		List<Booking> bookings = new ArrayList<>();
		bookings.add(booking);
		List<BookingsDto> bookingsDtos = new ArrayList<>();
		BDDMockito.given(trainRepository.existsByTrainName(booking.getTrainName())).willReturn(false);
		Object object = trainBookingService.bookingTrainTickets("sss", "puri", "durg", Date.valueOf("2020-11-11"),
				"train1", "3-tire ac", bookingsDtos);
		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing bookingTrainTickets1")
	@Test
	void testBookingTrainTickets1() throws Exception {
		Booking booking = new Booking(1, "puri", "durg", "train1", "station1", Date.valueOf("2020-11-11"),
				Time.valueOf("12:22:00"), "station3", Date.valueOf("2020-11-14"), Time.valueOf("12:00:00"), "user",
				"name", 23, "male", "3-tire ac", "123321");
		List<Booking> bookings = new ArrayList<>();
		bookings.add(booking);
		List<BookingsDto> bookingsDtos = new ArrayList<>();
		Train train = new Train(1, "puri", "durg", "train1", "3-tire ac");
		List<String> stations = new ArrayList<>();

		BDDMockito.given(trainRepository.existsByTrainName(booking.getTrainName())).willReturn(true);
		BDDMockito.given(trainRepository.findByTrainName(booking.getTrainName())).willReturn(train);
		BDDMockito.given(stationRepository.findStationsByTrainId(train.getTrainId())).willReturn(stations);

		Object object = trainBookingService.bookingTrainTickets("sss", "puri", "durg", Date.valueOf("2020-11-11"),
				"train1", "3-tire ac", bookingsDtos);
		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing bookingTrainTickets2")
	@Test
	void testBookingTrainTickets2() throws Exception {
		Booking booking = new Booking(1, "puri", "durg", "train1", "station1", Date.valueOf("2020-11-11"),
				Time.valueOf("12:22:00"), "station3", Date.valueOf("2020-11-14"), Time.valueOf("12:00:00"), "user",
				"name", 23, "male", "3-tire ac", "123321");
		List<Booking> bookings = new ArrayList<>();
		bookings.add(booking);
		List<BookingsDto> bookingsDtos = new ArrayList<>();
		Train train = new Train(1, "puri", "durg", "train1", "3-tire ac");
		List<String> stations = new ArrayList<>();
		stations.add("station1");
		stations.add("station3");

		BDDMockito.given(trainRepository.existsByTrainName(booking.getTrainName())).willReturn(true);
		BDDMockito.given(trainRepository.findByTrainName(booking.getTrainName())).willReturn(train);
		BDDMockito.given(stationRepository.findStationsByTrainId(train.getTrainId())).willReturn(stations);

		Object object = trainBookingService.bookingTrainTickets("sss", "station1", "durg", Date.valueOf("2020-11-11"),
				"train1", "3-tire ac", bookingsDtos);
		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing bookingTrainTickets3")
	@Test
	void testBookingTrainTickets3() throws Exception {
		Booking booking = new Booking(1, "puri", "durg", "train1", "station1", Date.valueOf("2020-11-11"),
				Time.valueOf("12:22:00"), "station3", Date.valueOf("2020-11-14"), Time.valueOf("12:00:00"), "user",
				"name", 23, "male", "3-tire ac", "123321");
		List<Booking> bookings = new ArrayList<>();
		bookings.add(booking);
		List<BookingsDto> bookingsDtos = new ArrayList<>();
		Train train = new Train(1, "puri", "durg", "train1", "3-tire ac");
		List<String> stations = new ArrayList<>();
		stations.add("station3");
		stations.add("station1");

		BDDMockito.given(trainRepository.existsByTrainName(booking.getTrainName())).willReturn(true);
		BDDMockito.given(trainRepository.findByTrainName(booking.getTrainName())).willReturn(train);
		BDDMockito.given(stationRepository.findStationsByTrainId(train.getTrainId())).willReturn(stations);

		Object object = trainBookingService.bookingTrainTickets("sss", "station1", "station3",
				Date.valueOf("2020-11-11"), "train1", "3-tire ac", bookingsDtos);
		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing bookingTrainTickets4")
	@Test
	void testBookingTrainTickets4() throws Exception {
		Booking booking = new Booking(1, "puri", "durg", "train1", "station1", Date.valueOf("2020-11-11"),
				Time.valueOf("12:22:00"), "station3", Date.valueOf("2020-11-14"), Time.valueOf("12:00:00"), "user",
				"name", 23, "male", "3-tire ac", "123321");
		List<Booking> bookings = new ArrayList<>();
		bookings.add(booking);
		List<BookingsDto> bookingsDtos = new ArrayList<>();
		Train train = new Train(1, "puri", "durg", "train1", "3-tire ac");
		List<String> stations = new ArrayList<>();
		stations.add("station1");

		BDDMockito.given(trainRepository.existsByTrainName(booking.getTrainName())).willReturn(true);
		BDDMockito.given(trainRepository.findByTrainName(booking.getTrainName())).willReturn(train);
		BDDMockito.given(stationRepository.findStationsByTrainId(train.getTrainId())).willReturn(stations);

		Object object = trainBookingService.bookingTrainTickets("sss", "station1", "station1",
				Date.valueOf("2020-11-11"), "train1", "3-tire ac", bookingsDtos);
		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing bookingTrainTickets5")
	@Test
	void testBookingTrainTickets5() throws Exception {
		Booking booking = new Booking(1, "puri", "durg", "train1", "station1", Date.valueOf("2020-11-11"),
				Time.valueOf("12:22:00"), "station3", Date.valueOf("2020-11-14"), Time.valueOf("12:00:00"), "user",
				"name", 23, "male", "3-tire ac", "123321");
		List<Booking> bookings = new ArrayList<>();
		bookings.add(booking);
		List<BookingsDto> bookingsDtos = new ArrayList<>();
		Train train = new Train(1, "puri", "durg", "train1", "3-tire ac");
		Station station = new Station(1, "station1", "city1", "platform1", Date.valueOf("2020-11-14"),
				Time.valueOf("12:00:00"));
		List<String> stations = new ArrayList<>();
		stations.add("station1");
		stations.add("station3");

		BDDMockito.given(trainRepository.existsByTrainName(booking.getTrainName())).willReturn(true);
		BDDMockito.given(trainRepository.findByTrainName(booking.getTrainName())).willReturn(train);
		BDDMockito.given(stationRepository.findStationsByTrainId(train.getTrainId())).willReturn(stations);
		BDDMockito.given(stationRepository.findStation(train.getTrainId(), booking.getFrom())).willReturn(station);

		Object object = trainBookingService.bookingTrainTickets("sss", "station1", "station3",
				Date.valueOf("2020-11-11"), "train1", "3-tire ac", bookingsDtos);
		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing bookingTrainTickets6")
	@Test
	void testBookingTrainTickets6() throws Exception {
		Booking booking = new Booking(1, "puri", "durg", "train1", "station1", Date.valueOf("2020-11-11"),
				Time.valueOf("12:22:00"), "station3", Date.valueOf("2020-11-14"), Time.valueOf("12:00:00"), "user",
				"name", 23, "male", "3-tire ac", "123321");
		List<Booking> bookings = new ArrayList<>();
		bookings.add(booking);
		List<BookingsDto> bookingsDtos = new ArrayList<>();
		Train train = new Train(1, "puri", "durg", "train1", "3-tire ac");
		Station station = new Station(1, "station1", "city1", "platform1", Date.valueOf("2020-11-14"),
				Time.valueOf("12:00:00"));
		List<String> stations = new ArrayList<>();
		stations.add("station1");
		stations.add("station3");
		List<Seat> seats = new ArrayList<>();

		BDDMockito.given(trainRepository.existsByTrainName(booking.getTrainName())).willReturn(true);
		BDDMockito.given(trainRepository.findByTrainName(booking.getTrainName())).willReturn(train);
		BDDMockito.given(stationRepository.findStationsByTrainId(train.getTrainId())).willReturn(stations);
		BDDMockito.given(stationRepository.findStation(train.getTrainId(), booking.getFrom())).willReturn(station);
		BDDMockito.given(seatRepository.findByBerthName(booking.getBerthName(), booking.getTrainName()))
				.willReturn(seats);

		Object object = trainBookingService.bookingTrainTickets("sss", "station1", "station3",
				Date.valueOf("2020-11-14"), "train1", "3-tire ac", bookingsDtos);
		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing bookingTrainTickets7")
	@Test
	void testBookingTrainTickets7() throws Exception {
		Booking booking = new Booking(1, "puri", "durg", "train1", "station1", Date.valueOf("2020-11-11"),
				Time.valueOf("12:22:00"), "station3", Date.valueOf("2020-11-14"), Time.valueOf("12:00:00"), "user",
				"name", 23, "male", "3-tire ac", "123321");
		BookingsDto bookingsDto = new BookingsDto(null, 22, "male");
		List<Booking> bookings = new ArrayList<>();
		bookings.add(booking);
		List<BookingsDto> bookingsDtos = new ArrayList<>();
		bookingsDtos.add(bookingsDto);
		Train train = new Train(1, "puri", "durg", "train1", "3-tire ac");
		Station station = new Station(1, "station1", "city1", "platform1", Date.valueOf("2020-11-14"),
				Time.valueOf("12:00:00"));
		List<String> stations = new ArrayList<>();
		stations.add("station1");
		stations.add("station3");

		Seat seat = new Seat(1, "train1", "3-tire ac", "acscdc", "not Booked");
		List<Seat> seats = new ArrayList<>();
		seats.add(seat);

		BDDMockito.given(trainRepository.existsByTrainName(booking.getTrainName())).willReturn(true);
		BDDMockito.given(trainRepository.findByTrainName(booking.getTrainName())).willReturn(train);
		BDDMockito.given(stationRepository.findStationsByTrainId(train.getTrainId())).willReturn(stations);
		BDDMockito.given(stationRepository.findStation(train.getTrainId(), booking.getFrom())).willReturn(station);
		BDDMockito.given(seatRepository.findByBerthName(booking.getBerthName(), booking.getTrainName()))
				.willReturn(seats);

		Object object = trainBookingService.bookingTrainTickets("sss", "station1", "station3",
				Date.valueOf("2020-11-14"), "train1", "3-tire ac", bookingsDtos);
		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing bookingTrainTickets8")
	@Test
	void testBookingTrainTickets8() throws Exception {
		Booking booking = new Booking(1, "puri", "durg", "train1", "station1", Date.valueOf("2020-11-11"),
				Time.valueOf("12:22:00"), "station3", Date.valueOf("2020-11-14"), Time.valueOf("12:00:00"), "user",
				"name", 23, "male", "3-tire ac", "123321");
		BookingsDto bookingsDto = new BookingsDto("sibu", 0, "male");
		List<Booking> bookings = new ArrayList<>();
		bookings.add(booking);
		List<BookingsDto> bookingsDtos = new ArrayList<>();
		bookingsDtos.add(bookingsDto);
		Train train = new Train(1, "puri", "durg", "train1", "3-tire ac");
		Station station = new Station(1, "station1", "city1", "platform1", Date.valueOf("2020-11-14"),
				Time.valueOf("12:00:00"));
		List<String> stations = new ArrayList<>();
		stations.add("station1");
		stations.add("station3");

		Seat seat = new Seat(1, "train1", "3-tire ac", "acscdc", "not Booked");
		List<Seat> seats = new ArrayList<>();
		seats.add(seat);

		BDDMockito.given(trainRepository.existsByTrainName(booking.getTrainName())).willReturn(true);
		BDDMockito.given(trainRepository.findByTrainName(booking.getTrainName())).willReturn(train);
		BDDMockito.given(stationRepository.findStationsByTrainId(train.getTrainId())).willReturn(stations);
		BDDMockito.given(stationRepository.findStation(train.getTrainId(), booking.getFrom())).willReturn(station);
		BDDMockito.given(seatRepository.findByBerthName(booking.getBerthName(), booking.getTrainName()))
				.willReturn(seats);

		Object object = trainBookingService.bookingTrainTickets("sss", "station1", "station3",
				Date.valueOf("2020-11-14"), "train1", "3-tire ac", bookingsDtos);
		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing bookingTrainTickets9")
	@Test
	void testBookingTrainTickets9() throws Exception {
		Booking booking = new Booking(1, "puri", "durg", "train1", "station1", Date.valueOf("2020-11-11"),
				Time.valueOf("12:22:00"), "station3", Date.valueOf("2020-11-14"), Time.valueOf("12:00:00"), "user",
				"name", 23, "male", "3-tire ac", "123321");
		BookingsDto bookingsDto = new BookingsDto("sibu", 22, null);
		List<Booking> bookings = new ArrayList<>();
		bookings.add(booking);
		List<BookingsDto> bookingsDtos = new ArrayList<>();
		bookingsDtos.add(bookingsDto);
		Train train = new Train(1, "puri", "durg", "train1", "3-tire ac");
		Station station = new Station(1, "station1", "city1", "platform1", Date.valueOf("2020-11-14"),
				Time.valueOf("12:00:00"));
		List<String> stations = new ArrayList<>();
		stations.add("station1");
		stations.add("station3");

		Seat seat = new Seat(1, "train1", "3-tire ac", "acscdc", "not Booked");
		List<Seat> seats = new ArrayList<>();
		seats.add(seat);

		BDDMockito.given(trainRepository.existsByTrainName(booking.getTrainName())).willReturn(true);
		BDDMockito.given(trainRepository.findByTrainName(booking.getTrainName())).willReturn(train);
		BDDMockito.given(stationRepository.findStationsByTrainId(train.getTrainId())).willReturn(stations);
		BDDMockito.given(stationRepository.findStation(train.getTrainId(), booking.getFrom())).willReturn(station);
		BDDMockito.given(seatRepository.findByBerthName(booking.getBerthName(), booking.getTrainName()))
				.willReturn(seats);

		Object object = trainBookingService.bookingTrainTickets("sss", "station1", "station3",
				Date.valueOf("2020-11-14"), "train1", "3-tire ac", bookingsDtos);
		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing bookingTrainTickets10")
	@Test
	void testBookingTrainTickets10() throws Exception {
		Booking booking = new Booking(1, "puri", "durg", "train1", "station1", Date.valueOf("2020-11-11"),
				Time.valueOf("12:22:00"), "station3", Date.valueOf("2020-11-14"), Time.valueOf("12:00:00"), "user",
				"name", 23, "male", "3-tire ac", "123321");
		BookingsDto bookingsDto = new BookingsDto("sibu", 22, "male");
		List<Booking> bookings = new ArrayList<>();
		bookings.add(booking);
		List<BookingsDto> bookingsDtos = new ArrayList<>();
		bookingsDtos.add(bookingsDto);
		Train train = new Train(1, "puri", "durg", "train1", "3-tire ac");
		Station station = new Station(1, "station1", "city1", "platform1", Date.valueOf("2020-11-14"),
				Time.valueOf("12:00:00"));
		List<String> stations = new ArrayList<>();
		stations.add("station1");
		stations.add("station3");

		Seat seat = new Seat(1, "train1", "3-tire ac", "acscdc", "not Booked");
		List<Seat> seats = new ArrayList<>();
		seats.add(seat);

		List<String> seatList = new ArrayList<>();

		BDDMockito.given(trainRepository.existsByTrainName(booking.getTrainName())).willReturn(true);
		BDDMockito.given(trainRepository.findByTrainName(booking.getTrainName())).willReturn(train);
		BDDMockito.given(stationRepository.findStationsByTrainId(train.getTrainId())).willReturn(stations);
		BDDMockito.given(stationRepository.findStation(train.getTrainId(), booking.getFrom())).willReturn(station);
		BDDMockito.given(seatRepository.findByBerthName(booking.getBerthName(), booking.getTrainName()))
				.willReturn(seats);
		BDDMockito.given(trainRepository.getSourceByTrain(booking.getTrainName())).willReturn(booking.getSource());
		BDDMockito.given(trainRepository.getDestinationByTrain(booking.getTrainName()))
				.willReturn(booking.getDestination());
		BDDMockito.given(stationRepository.findTime(Date.valueOf("2020-11-14"), "station1", train.getTrainId()))
				.willReturn(booking.getTimeFrom());
		BDDMockito.given(stationRepository.findReturnDate(booking.getTo(), train.getTrainId()))
				.willReturn(booking.getReturnDate());
		BDDMockito.given(stationRepository.findTime(booking.getReturnDate(), booking.getTo(), train.getTrainId()))
				.willReturn(booking.getReturnTime());
		BDDMockito.given(seatRepository.findSeats(booking.getTrainName(), booking.getBerthName(), "not booked"))
				.willReturn(seatList);

		Object object = trainBookingService.bookingTrainTickets("sss", "station1", "station3",
				Date.valueOf("2020-11-14"), "train1", "3-tire ac", bookingsDtos);
		Assertions.assertThat(object).isNotNull();

	}

	@DisplayName("testing bookingTrainTickets11")
	@Test
	void testBookingTrainTickets11() throws Exception {
		Booking booking = new Booking(1, "puri", "durg", "train1", "station1", Date.valueOf("2020-11-11"),
				Time.valueOf("12:22:00"), "station3", Date.valueOf("2020-11-14"), Time.valueOf("12:00:00"), "user",
				"name", 23, "male", "3-tire ac", "123321");
		BookingsDto bookingsDto = new BookingsDto("sibu", 22, "male");
		List<Booking> bookings = new ArrayList<>();
		bookings.add(booking);
		List<BookingsDto> bookingsDtos = new ArrayList<>();
		bookingsDtos.add(bookingsDto);
		Train train = new Train(1, "puri", "durg", "train1", "3-tire ac");
		Station station = new Station(1, "station1", "city1", "platform1", Date.valueOf("2020-11-14"),
				Time.valueOf("12:00:00"));
		List<String> stations = new ArrayList<>();
		stations.add("station1");
		stations.add("station3");

		Seat seat = new Seat(1, "train1", "3-tire ac", "acscdc", "not Booked");
		Seat seat1 = new Seat();
		List<Seat> seats = new ArrayList<>();
		seats.add(seat);

		List<String> seatList = new ArrayList<>();
		seatList.add("acscdc");

		BDDMockito.given(trainRepository.existsByTrainName(booking.getTrainName())).willReturn(true);
		BDDMockito.given(trainRepository.findByTrainName(booking.getTrainName())).willReturn(train);
		BDDMockito.given(stationRepository.findStationsByTrainId(train.getTrainId())).willReturn(stations);
		BDDMockito.given(stationRepository.findStation(train.getTrainId(), booking.getFrom())).willReturn(station);
		BDDMockito.given(seatRepository.findByBerthName(booking.getBerthName(), booking.getTrainName()))
				.willReturn(seats);
		BDDMockito.given(trainRepository.getSourceByTrain(booking.getTrainName())).willReturn(booking.getSource());
		BDDMockito.given(trainRepository.getDestinationByTrain(booking.getTrainName()))
				.willReturn(booking.getDestination());
		BDDMockito.given(stationRepository.findTime(Date.valueOf("2020-11-14"), "station1", train.getTrainId()))
				.willReturn(booking.getTimeFrom());
		BDDMockito.given(stationRepository.findReturnDate(booking.getTo(), train.getTrainId()))
				.willReturn(booking.getReturnDate());
		BDDMockito.given(stationRepository.findTime(booking.getReturnDate(), booking.getTo(), train.getTrainId()))
				.willReturn(booking.getReturnTime());
		BDDMockito.given(seatRepository.findSeats(booking.getTrainName(), booking.getBerthName(), "not booked"))
				.willReturn(seatList);
		BDDMockito.given(trainBookingRepository.save(booking)).willReturn(booking);
		BDDMockito.given(seatRepository.updateSeatStatus("train1", "3-tire ac", "acscdc")).willReturn(seat);
		seat1.setStatus("booked");
		BDDMockito.given(seatRepository.save(seat1)).willReturn(seat1);

		Object object = trainBookingService.bookingTrainTickets("sss", "station1", "station3",
				Date.valueOf("2020-11-14"), "train1", "3-tire ac", bookingsDtos);
		Assertions.assertThat(object).isNotNull();

	}
}

package com.remock.trainService.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.RestController;

import com.remock.trainService.dtos.BookingsDto;
import com.remock.trainService.entities.Booking;
import com.remock.trainService.entities.Seat;
import com.remock.trainService.entities.Station;
import com.remock.trainService.entities.Train;
import com.remock.trainService.repositories.BookingRepository;
import com.remock.trainService.repositories.SeatRepository;
import com.remock.trainService.repositories.StationRepository;
import com.remock.trainService.repositories.TrainRepository;

@RestController
public class TrainBookingService {
	BookingRepository trainBookingRepository;
	TrainRepository trainRepository;
	StationRepository stationRepository;
	SeatRepository seatRepository;

	public TrainBookingService(BookingRepository trainBookingRepository, TrainRepository trainRepository,
			StationRepository stationRepository, SeatRepository seatRepository) {
		this.trainBookingRepository = trainBookingRepository;
		this.trainRepository = trainRepository;
		this.seatRepository = seatRepository;
		this.stationRepository = stationRepository;
	}

	public Object bookingTrainTickets(String userId, String from, String to, Date dateFrom, String trainName,
			String berthName, List<BookingsDto> bookingsDtos) {
		if (!(trainRepository.existsByTrainName(trainName))) {
			return ("{\"status\":\"entered train name does not exist in our list.\"}");
		}
		Train train = trainRepository.findByTrainName(trainName);
		List<String> stations = new ArrayList<>();
		stations = stationRepository.findStationsByTrainId(train.getTrainId());
		if (!(stations.contains(from))) {
			return ("{\"Status\":\"Entered " + from + " is not present on " + trainName + "\'s station list.\"}");
		}
		if (!(stations.contains(to))) {
			return ("{\"Status\":\"Entered " + to + " is not present on " + trainName + "\'s station list.\"}");
		}
		if (stations.indexOf(from) > stations.indexOf(to)) {
			return ("{\"Status\":\"Entered train " + trainName + " goes from " + to + " to " + from
					+ ". Please choose another train that goes from " + from + " to " + to + ".\"}");
		}
		if (stations.indexOf(from) == stations.indexOf(to)) {
			return ("{\"Status\":\"Your from and to stations are same.\"}");
		}
		Station station = stationRepository.findStation(train.getTrainId(), from);
		if (!(station.getDate().equals(dateFrom))) {
			return ("{\"Status\":\"Your train is not on the given station on given date.\"}");
		}
		if (seatRepository.findByBerthName(berthName, trainName).size() == 0) {
			return ("{\"Status\":\"Entered berthName does not exist on that train.\"}");
		} else {

			for (BookingsDto bookingDto : bookingsDtos) {
				if (bookingDto.getName() == null) {
					return ("{\"Status\":\"Enter Name.\"}");
				}
				if (bookingDto.getAge() == 0) {
					return ("{\"Status\":\"Enter Age.\"}");
				}
				if (bookingDto.getGender() == null) {
					return ("{\"Status\":\"Enter gender.\"}");
				} else {
					Booking booking = new Booking();
					booking.setUserId(userId);
					booking.setSource(trainRepository.getSourceByTrain(trainName));
					booking.setDestination(trainRepository.getDestinationByTrain(trainName));
					booking.setTrainName(trainName);
					booking.setFrom(from);
					booking.setDateFrom(dateFrom);
					booking.setTimeFrom(stationRepository.findTime(dateFrom, from, train.getTrainId()));
					booking.setTo(to);
					booking.setReturnDate(stationRepository.findReturnDate(to, train.getTrainId()));
					booking.setReturnTime(stationRepository.findTime(booking.getReturnDate(), to, train.getTrainId()));
					booking.setName(bookingDto.getName());
					booking.setAge(bookingDto.getAge());
					booking.setGender(bookingDto.getGender());
					booking.setBerthName(berthName);
					List<String> seats = new ArrayList<>();
					seats = seatRepository.findSeats(trainName, berthName, "not booked");
					if ((seats.size() == 0)) {
						return ("{\"Status\":\"This compartment seats are full. from " + bookingDto.getName()
								+ " please book in different compartment.\"}");

					} else {
						Random random = new Random();
						booking.setSeatNo(seats.get(random.nextInt(seats.size())));
						trainBookingRepository.save(booking);
						Seat seat = seatRepository.updateSeatStatus(booking.getTrainName(), booking.getBerthName(),
								booking.getSeatNo());
						seat.setStatus("booked");
						seatRepository.save(seat);
					}

				}
			}

		}

		return ("{\"Status\":\"seat booked successfully.\"}");
	}

	public Object getUserBookingList(String userId, Date dateFrom) {
		List<Booking> bookings = new ArrayList<>();
		bookings = trainBookingRepository.findBookedSeatList(userId, dateFrom);
		if (bookings.size() > 0) {
			return bookings;
		} else {
			return ("{\"Status\":\"With the entered user id and date there are no booked tickets.\"}");
		}
	}

	public Object getUserBookingAllList(String userId) {
		if (trainBookingRepository.findByUserId(userId).size() == 0) {
			return ("{\"status\":\"In this user id there are no tickets booked yet.\"}");
		} else {
			return trainBookingRepository.findByUserId(userId);
		}

	}
}

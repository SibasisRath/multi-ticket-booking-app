package com.remock.busService.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.remock.busService.dtos.BookingsDto;
import com.remock.busService.entities.Bookings;
import com.remock.busService.entities.BusSourceDestination;
import com.remock.busService.entities.BusVacancy;
import com.remock.busService.repositories.BookingsRepository;
import com.remock.busService.repositories.BusSourceDestinationRepository;
import com.remock.busService.repositories.BusStopsRepository;
import com.remock.busService.repositories.BusVacancyRepository;

@Service
public class BookingsService {
	private static final Logger log = LoggerFactory.getLogger(BookingsService.class);
	BookingsRepository bookingRepository;
	BusVacancyRepository busVacancyRepository;
	RestTemplate restTemplate;
	BusStopsRepository busStopsRepository;
	BusSourceDestinationRepository busSourceDestinationRepository;

	public BookingsService(BookingsRepository bookingsRepository, BusVacancyRepository busVacancyRepository,
			BusSourceDestinationRepository busSourceDestinationRepository, BusStopsRepository busStopsRepository) {
		this.bookingRepository = bookingsRepository;
		this.busVacancyRepository = busVacancyRepository;
		this.busSourceDestinationRepository = busSourceDestinationRepository;
		this.busStopsRepository = busStopsRepository;
	}

	public String bookingTickets(BookingsDto dto) {
		log.info("inside book ticket controller.");
		Bookings bookings = new Bookings();
		BusVacancy busv = new BusVacancy();
		List<String> busStopList = new ArrayList<>();
		if (dto.getUserId() == null) {
			return ("{\"status\":\"enter user id.\"}");
		}
		if (dto.getBpoint() == null) {
			return ("{\"status\":\"enter boarding point.\"}");
		}
		if (dto.getBus() == null) {
			return ("{\"status\":\"enter bus.\"}");
		}

		if (dto.getDateFrom() == null) {
			return ("{\"status\":\"enter date from.\"}");
		}
		if (dto.getDpoint() == null) {
			return ("{\"status\":\"enter dropping point.\"}");
		}
		if (dto.getSeats() == 0) {
			return ("{\"status\":\"enter seats.\"}");
		}
		if ((busVacancyRepository.checkBusVacancy(dto.getBus())) < dto.getSeats()) {
			return ("{\"status\":\"This bus does not have enough vacancy.\"}");
		}
		busStopList = busStopsRepository.findBusStops(dto.getBus());
		if (!(busStopList.contains(dto.getBpoint()))) {
			return ("{\"status\":\"This boarding point is not covered by this bus.\"}");
		}
		if (!(busStopList.contains(dto.getDpoint()))) {
			return ("{\"status\":\"This dropping point is not covered by this bus.\"}");
		}
		if (busStopList.indexOf(dto.getBpoint()) > busStopList.indexOf(dto.getDpoint())) {
			return ("{\"status\":\"dropping bus stop should come after boarding bus stop.\"}");
		}
		/*
		 * if (!(busStopsRepository.getDate(dto.getBus(),
		 * dto.getBpoint()).equals(dto.getDateFrom()))) { return
		 * ("{\"status\":\"the dates are not matched."+busStopsRepository.getDate(dto.
		 * getBus(), dto.getBpoint())+" "+dto.getDateFrom()+"\"}");
		 * 
		 * }
		 */ else {

			bookings.setUserId(dto.getUserId());
			bookings.setBpoint(dto.getBpoint());
			bookings.setBus(dto.getBus());
			bookings.setDateFrom(dto.getDateFrom());
			bookings.setDpoint(dto.getDpoint());
			int busSD = busStopsRepository.getBusSD(bookings.getBpoint(), bookings.getBus());
			BusSourceDestination busSourceDestination = busSourceDestinationRepository.getBusSourceDestination(busSD);
			bookings.setSource(busSourceDestination.getSource());
			bookings.setDestination(busSourceDestination.getDestination());
			Date returnDate = busStopsRepository.getDate(bookings.getBus(), bookings.getDpoint());
			bookings.setReturnDate(returnDate);
			bookings.setSeats(dto.getSeats());

			bookingRepository.save(bookings);
			busv = busVacancyRepository.getByBus(bookings.getBus());
			busv.setVacancy(busv.getVacancy() - bookings.getSeats());
			busVacancyRepository.save(busv);
			log.info("Bus vacancy seats are updated.");
			return ("{\"status\": \"bus booked.\"}");
		}

	}

	public Object gettingBookedDetails(String userId, Date dateFrom) {
		log.info("inside get booking details controller.");
		if (bookingRepository.findByBus(userId, dateFrom) == null) {
			return ("{\"status\": \"check inputs.\"}");
		} else {
			return (bookingRepository.findByBus(userId, dateFrom));
		}
	}

	public Object gettingBusBookingList(String id) {
		log.info("inside get user list of booked ticket controllers controller.");
		if (bookingRepository.findByUserId(id).size() == 0) {
			return ("{\"status\": \"No tickets has been booked in this user id.\"}");
		} else {
			return (bookingRepository.findByUserId(id));
		}

	}
}

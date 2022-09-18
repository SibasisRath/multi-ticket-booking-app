package com.remock.hotelService.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.remock.hotelService.dtos.HotelBookingsDto;
import com.remock.hotelService.entities.HotelBooking;
import com.remock.hotelService.entities.Vacancy;
import com.remock.hotelService.repositories.CityHotelRepository;
import com.remock.hotelService.repositories.HotelBookingRepository;
import com.remock.hotelService.repositories.VacancyRepository;

@Service
public class HotelBookingsService {
	private static final Logger log = LoggerFactory.getLogger(HotelBookingsService.class);
	private HotelBookingRepository hotelBookingRepository;
	private CityHotelRepository cityHotelRepository;
	private VacancyRepository vacancyRepository;

	public HotelBookingsService(HotelBookingRepository hotelBookingRepository, CityHotelRepository cityHotelRepository,
			VacancyRepository vacancyRepository) {
		this.hotelBookingRepository = hotelBookingRepository;
		this.cityHotelRepository = cityHotelRepository;
		this.vacancyRepository = vacancyRepository;
	}

	public Object bookHotelService(String hotel, Date checkindate, Date checkoutdate, String userId,
			List<HotelBookingsDto> hotelBookingsDtos) {
		log.info("inside book hotel service.");
		if (!(cityHotelRepository.existsByHotelName(hotel))) {
			return ("{\"status\":\"Hotel does not exist in this service.\"}");
		}
		if (checkindate.after(checkoutdate)) {
			return ("{\"status\":\"check in date should come before check out date.\"}");
		} else {
			for (HotelBookingsDto bookingsDto : hotelBookingsDtos) {
				if (bookingsDto.getRoomType() == null) {
					return ("{\"status\":\"enter room type.\"}");
				}
				if (bookingsDto.getPersons() == 0) {
					return ("{\"status\":\"enter persons.\"}");
				}
				if (vacancyRepository.existsByRoomType(bookingsDto.getRoomType())) {
					if ((bookingsDto.getRoomType().equals("3-bed room")) && (bookingsDto.getPersons() > 3)) {
						return ("{\"status\":\" in 3-bed room more than three persons are not allowed.\"}");
					}
					if ((bookingsDto.getRoomType().equals("2-bed room")) && (bookingsDto.getPersons() > 2)) {
						return ("{\"status\":\" in 2-bed room more than two persons are not allowed.\"}");
					}
					if ((bookingsDto.getRoomType().equals("1-bed room")) && (bookingsDto.getPersons() > 1)) {
						return ("{\"status\":\" in 1-bed room more than one persons are not allowed.\"}");
					}
				} else {
					return ("{\"status\":\"This type of rooms are not available right now.\"}");
				}
				HotelBooking hotelBooking = new HotelBooking();
				hotelBooking.setUserId(userId);
				hotelBooking.setCheckInDate(checkindate);
				hotelBooking.setCheckOutDate(checkoutdate);
				hotelBooking.setHotel(hotel);
				hotelBooking.setRoomType(bookingsDto.getRoomType());
				hotelBooking.setPersons(bookingsDto.getPersons());
				int hotelId = cityHotelRepository.getIdByHotelName(hotelBooking.getHotel());
				Vacancy vacancy = vacancyRepository.getVacancy(bookingsDto.getRoomType(), hotelId);
				if (vacancy.getAvailableRooms() > 0) {
					hotelBookingRepository.save(hotelBooking);
					vacancy.setAvailableRooms(vacancy.getAvailableRooms() - 1);
					vacancyRepository.save(vacancy);
				} else {
					return ("{\"status\":\"All the " + bookingsDto.getRoomType()
							+ " are filled please check the availablity and book the rest. \"}");
				}

			}

			return ("{\"status\":\"Hotel is booked successfully.\"}");
		}

	}

	public Object getHotelBookingDetails(String userId, Date checkInDate) {
		log.info("inside get booked hotels details of a user on a date service.");
		if (hotelBookingRepository.existsByUserId(userId)) {
			List<Date> checkInDates = new ArrayList<>();
			checkInDates = hotelBookingRepository.findCheckInDates(userId);
			if (checkInDates.contains(checkInDate)) {
				List<HotelBooking> bookings = new ArrayList<>();
				bookings = hotelBookingRepository.findUserBookingList(userId, checkInDate);
				return bookings;
			} else {
				return ("{\"status\":\"On the entered check in date there are no rooms booked.\"}");
			}
		} else {
			return ("{\"status\":\"The entered user id have not booked any rooms.\"}");
		}
	}

	public Object getHotelBookingDetailList(String userId) {
		log.info("inside get booked hotels details of a user service.");
		List<HotelBooking> hotelBookingList = new ArrayList<>();
		hotelBookingList = hotelBookingRepository.findByUserId(userId);
		if (hotelBookingList.size() > 0) {
			return hotelBookingRepository.findByUserId(userId);
		} else {
			return ("{\"status\":\"The entered user id have not booked any rooms.\"}");
		}
	}
}

package com.remock.busService.dtos;

import java.time.LocalDate;

public class BookingsDto {
	private int busBookingId;
	private String userId;
	private String bus;
	private String source;
	private String destination;
	private String bpoint;
	private String dpoint;
	private LocalDate dateFrom;
	private LocalDate returnDate;
	private int seats;

	public BookingsDto() {

	}

	public BookingsDto(String userId, String bus, String source, String destination, String bpoint,
			String dpoint, LocalDate dateFrom, LocalDate returnDate, int seats) {
		this.userId = userId;
		this.bus = bus;
		this.source = source;
		this.destination = destination;
		this.bpoint = bpoint;
		this.dpoint = dpoint;
		this.dateFrom = dateFrom;
		this.returnDate = returnDate;
		this.seats = seats;
	}

	public String getUserId() {
		return userId;
	}

	public String getBus() {
		return bus;
	}

	public void setBus(String bus) {
		this.bus = bus;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getBpoint() {
		return bpoint;
	}

	public void setBpoint(String bpoint) {
		this.bpoint = bpoint;
	}

	public String getDpoint() {
		return dpoint;
	}

	public void setDpoint(String dpoint) {
		this.dpoint = dpoint;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	
}

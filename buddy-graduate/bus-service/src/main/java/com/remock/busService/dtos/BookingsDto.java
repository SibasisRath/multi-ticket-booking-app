package com.remock.busService.dtos;

import java.sql.Date;

public class BookingsDto {
	private int busBookingId;
	private String userId;
	private String bus;
	private String source;
	private String destination;
	private String bpoint;
	private String dpoint;
	private Date dateFrom;
	private Date returnDate;
	private int seats;

	public BookingsDto() {

	}

	public BookingsDto(int busBookingId, String userId, String bus, String source, String destination, String bpoint,
			String dpoint, Date dateFrom, Date returnDate, int seats) {
		this.busBookingId = busBookingId;
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

	public int getBusBookingId() {
		return busBookingId;
	}

	public void setBusBookingId(int busBookingId) {
		this.busBookingId = busBookingId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	
}

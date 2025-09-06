package com.remock.busService.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "bookings")
public class Bookings {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "busbookingid")
	private int busBookingId;
	@Column(name = "userid", nullable = false)
    @NotBlank
	private String userId;
	@Column(name = "bus")
	private String bus;
	@Column(name = "source")
	private String source;
	@Column(name = "destination")
	private String destination;
	@Column(name = "boardingpoint")
	private String bpoint;
	@Column(name = "droppingpoint")
	private String dpoint;
	@Column(name = "datefrom")
	private LocalDate dateFrom;
	@Column(name = "returndate")
	private LocalDate returnDate;
	@Column(name = "seats", nullable = false)
    @Min(1)
	private int seats;

	public Bookings() {

	}

	public Bookings(int busBookingId, String userId, String bus, String source, String destination, String bpoint,
			String dpoint, LocalDate dateFrom, LocalDate returnDate, int seats) {
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

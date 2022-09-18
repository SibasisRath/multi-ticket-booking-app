package com.remock.hotelService.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hotelbookings")
public class HotelBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hbookingid")
	private int hbookingid;
	@Column(name = "userid")
	private String userId;
	@Column(name = "hotel")
	private String hotel;
	@Column(name = "roomtype")
	private String roomType;
	@Column(name = "checkindate")
	private Date checkInDate;
	@Column(name = "checkoutdate")
	private Date checkOutDate;
	@Column(name = "persons")
	private int persons;

	public HotelBooking() {

	}

	public HotelBooking(int hbookingid, String userId, String hotel, String roomType, Date checkInDate,
			Date checkOutDate, int persons) {
		this.hbookingid = hbookingid;
		this.userId = userId;
		this.hotel = hotel;
		this.roomType = roomType;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.persons = persons;
	}

	public int getHbookingid() {
		return hbookingid;
	}

	public void setHbookingid(int hbookingid) {
		this.hbookingid = hbookingid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public int getPersons() {
		return persons;
	}

	public void setPersons(int persons) {
		this.persons = persons;
	}

}

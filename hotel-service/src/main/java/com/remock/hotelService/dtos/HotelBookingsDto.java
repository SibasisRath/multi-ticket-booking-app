package com.remock.hotelService.dtos;

import java.sql.Date;

public class HotelBookingsDto {
	private int hbookingid;
	private String userId;
	private String hotel;
	private String roomType;
	private Date checkInDate;
	private Date checkOutDate;
	private int persons;

	public HotelBookingsDto() {

	}

	public HotelBookingsDto(int hbookingid, String userId, String hotel, String roomType, Date checkInDate,
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

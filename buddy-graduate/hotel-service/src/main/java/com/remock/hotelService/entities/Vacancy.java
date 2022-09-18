package com.remock.hotelService.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "vacancy")
public class Vacancy {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "roomtype")
	private String roomType;
	@Column(name = "availablerooms")
	private int availableRooms;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cityhotel")
	CityHotel cityHotel;

	public Vacancy() {

	}

	public Vacancy(int id, String roomType, int availableRooms) {
		this.id = id;
		this.roomType = roomType;
		this.availableRooms = availableRooms;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getAvailableRooms() {
		return availableRooms;
	}

	public void setAvailableRooms(int availableRooms) {
		this.availableRooms = availableRooms;
	}

	public CityHotel getCityHotel() {
		return cityHotel;
	}

	public void setCityHotel(CityHotel cityHotel) {
		this.cityHotel = cityHotel;
	}

}

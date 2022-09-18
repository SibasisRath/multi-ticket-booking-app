package com.remock.trainService.entities;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "stations")
public class Station {
	@Id
	@Column(name = "stationid")
	private int stationId;
	@Column(name = "stationname")
	private String stationName;
	@Column(name = "city")
	private String city;
	@Column(name = "platform")
	private String platform;
	@Column(name = "date")
	private Date date;
	@Column(name = "time")
	private Time time;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "trainid")
	Train trains;
	
	
	

	public Station(int stationId, String stationName, String city, String platform, Date date, Time time) {
		this.stationId = stationId;
		this.stationName = stationName;
		this.city = city;
		this.platform = platform;
		this.date = date;
		this.time = time;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Station() {

	}

	
	public int getStationId() {
		return stationId;
	}

	public void setStationId(int stationId) {
		this.stationId = stationId;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public Train getTrains() {
		return trains;
	}

	public void setTrains(Train trains) {
		this.trains = trains;
	}

}

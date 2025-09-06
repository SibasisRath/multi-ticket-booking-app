package com.remock.busService.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "busstops")
public class BusStops {
	@Id
	@Column(name = "stopid")
	private int stopId;
	@Column(name = "bus")
	private String bus;
	@Column(name = "busstop")
	private String busStop;
	@Column(name = "city")
	private String city;
	@Column(name = "date")
    @Future(message = "End date must be in the future")
	private LocalDate date;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "busSD")
	private BusSourceDestination busSD;

	public BusStops() {

	}

	public BusStops(int stopId, String bus, String busStop, String city, LocalDate date) {
		this.stopId = stopId;
		this.bus = bus;
		this.busStop = busStop;
		this.city = city;
		this.date = date;
	}

	public int getStopId() {
		return stopId;
	}

	public void setStopId(int stopId) {
		this.stopId = stopId;
	}

	public String getBus() {
		return bus;
	}

	public void setBus(String bus) {
		this.bus = bus;
	}

	public String getBusStop() {
		return busStop;
	}

	public void setBusStop(String busStop) {
		this.busStop = busStop;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public BusSourceDestination getBusSD() {
		return busSD;
	}

	public void setBusSD(BusSourceDestination busSD) {
		this.busSD = busSD;
	}

}

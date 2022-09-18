package com.remock.trainService.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "trains")
public class Train {
	@Id
	@Column(name = "trainid")
	private int trainId;
	@Column(name = "source")
	private String source;
	@Column(name = "destination")
	private String destination;
	@Column(name = "trainname")
	private String trainName;
	@Column(name = "berthnames")
	private String berthNames;

	@OneToMany(mappedBy = "trains", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Station> stations = new ArrayList<>();

	public Train() {

	}

	public Train(int trainId, String source, String destination, String trainName, String berthNames) {
		this.trainId = trainId;
		this.source = source;
		this.destination = destination;
		this.trainName = trainName;
		this.berthNames = berthNames;
	}

	public int getTrainId() {
		return trainId;
	}

	public void setTrainId(int trainId) {
		this.trainId = trainId;
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

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getBerthNames() {
		return berthNames;
	}

	public void setBerthNames(String berthNames) {
		this.berthNames = berthNames;
	}

	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

}

package com.remock.busService.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bussourcedestination")
public class BusSourceDestination {
	@Id
	@Column(name = "sdid")
	private int id;
	@Column(name = "source")
	private String source;
	@Column(name = "destination")
	private String destination;
	@OneToMany(mappedBy = "busSD", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	List<BusStops> busInfo = new ArrayList<>();

	public BusSourceDestination() {

	}

	public BusSourceDestination(int id, String source, String destination) {
		this.id = id;
		this.source = source;
		this.destination = destination;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<BusStops> getBusInfo() {
		return busInfo;
	}

	public void setBusInfo(List<BusStops> busInfo) {
		this.busInfo = busInfo;
	}

}

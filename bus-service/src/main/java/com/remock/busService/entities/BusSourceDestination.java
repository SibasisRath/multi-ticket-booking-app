package com.remock.busService.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "bussourcedestination")
public class BusSourceDestination {
	@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sdid")
	private int id;
	@Column(name = "source")
	private String source;
	@Column(name = "destination")
	private String destination;
    @OneToMany(mappedBy = "busSD", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
	List<BusStops> busStops = new ArrayList<>();

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

	public List<BusStops> getBusStops() {
		return busStops;
	}

	public void setBusStops(List<BusStops> busStops) {
		this.busStops = busStops;
	}

    public void addStop(BusStops stop) {
        busStops.add(stop);
        stop.setBusSD(this);
    }

    public void removeStop(BusStops stop) {
        busStops.remove(stop);
        stop.setBusSD(null);
    }

}

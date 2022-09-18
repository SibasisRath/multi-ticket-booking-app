package com.remock.trainService.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seats")
public class Seat {
	@Id
	@Column(name = "seatid")
	private int seatId;
	@Column(name = "trainName")
	private String train;
	@Column(name = "berthname")
	private String berthName;
	@Column(name = "seatnumber")
	private String seatNumber;
	@Column(name = "status")
	private String status;

	public Seat() {

	}

	public Seat(int seatId, String train, String berthName, String seatNumber, String status) {
		this.seatId = seatId;
		this.train = train;
		this.berthName = berthName;
		this.seatNumber = seatNumber;
		this.status = status;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public String getTrain() {
		return train;
	}

	public void setTrain(String train) {
		this.train = train;
	}

	public String getBerthName() {
		return berthName;
	}

	public void setBerthName(String berthName) {
		this.berthName = berthName;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	

}

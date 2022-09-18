package com.remock.trainService.entities;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "trainbookingid")
	private int trainBookingId;
	@Column(name = "source")
	private String source;//done
	@Column(name = "destination")
	private String destination;//done
	@Column(name = "trainname")
	private String trainName;//done
	@Column(name = "fromstation")
	private String from;//done
	@Column(name = "datefrom")
	private Date dateFrom;//done
	@Column(name = "timefrom")
	private Time timeFrom;//done
	@Column(name = "tostation")
	private String to;//done
	@Column(name = "returndate")
	private Date returnDate;//done
	@Column(name = "returntime")
	private Time returnTime;//done
	@Column(name = "userid")
	private String userId; //done
	@Column(name = "name")
	private String name;//done
	@Column(name = "age")
	private int age;//done
	@Column(name = "gender")
	private String gender;//done
	@Column(name = "berthname")
	private String berthName;//done
	@Column(name = "seatno")
	private String seatNo;

	public Booking() {

	}

	public Booking(int trainBookingId, String source, String destination, String trainName, String from, Date dateFrom,
			Time timeFrom, String to, Date returnDate, Time returnTime, String userId, String name, int age,
			String gender, String berthName, String seatNo) {
		this.trainBookingId = trainBookingId;
		this.source = source;
		this.destination = destination;
		this.trainName = trainName;
		this.from = from;
		this.dateFrom = dateFrom;
		this.timeFrom = timeFrom;
		this.to = to;
		this.returnDate = returnDate;
		this.returnTime = returnTime;
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.berthName = berthName;
		this.seatNo = seatNo;
	}

	public int getTrainBookingId() {
		return trainBookingId;
	}

	public void setTrainBookingId(int trainBookingId) {
		this.trainBookingId = trainBookingId;
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

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Time getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(Time timeFrom) {
		this.timeFrom = timeFrom;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Time getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Time returnTime) {
		this.returnTime = returnTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBerthName() {
		return berthName;
	}

	public void setBerthName(String berthName) {
		this.berthName = berthName;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	
}

package com.remock.busService.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "busvacancy")
public class BusVacancy {
	@Id
	@Column(name = "bus")
	private String bus;
	@Column(name = "vacancy")
	private int vacancy;
	
	
	public BusVacancy() {
		
	}

	public BusVacancy(String bus, int vacancy) {
		this.bus = bus;
		this.vacancy = vacancy;
	}

	public String getBus() {
		return bus;
	}

	public void setBus(String bus) {
		this.bus = bus;
	}

	public int getVacancy() {
		return vacancy;
	}

	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}
	
	

}

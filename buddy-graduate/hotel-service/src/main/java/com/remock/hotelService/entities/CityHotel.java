package com.remock.hotelService.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hotels")
public class CityHotel {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "city")
	private String city;
	@Column(name = "hotelname")
	private String hotelName;
	@Column(name = "facilities")
	private String facilities;

	@OneToMany(mappedBy = "cityHotel", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Vacancy> vacancies = new ArrayList<>();

	public CityHotel() {

	}

	public CityHotel(int id, String city, String hotelName, String facilities) {
		this.id = id;
		this.city = city;
		this.hotelName = hotelName;
		this.facilities = facilities;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public List<Vacancy> getVacancies() {
		return vacancies;
	}

	public void setVacancies(List<Vacancy> vacancies) {
		this.vacancies = vacancies;
	}

	
}

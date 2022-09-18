package com.remock.userService.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {
	@Id
	@Column(name = "uid")
	private int uId;
	@Column(name = "userfirstname")
	private String userFirstName;
	@Column(name = "userlastname")
	private String userLastName;
	@Column(name = "phone")
	private String phone;
	@Column(name = "email")
	private String email;
	@Column(name = "country")
	private String country;
	@Column(name = "state")
	private String state;
	@Column(name = "district")
	private String district;
	@Column(name = "userid")
	private String userId;
	@Column(name = "pwd")
	private String pwd;

	public UserEntity() {

	}

	public UserEntity(int uId, String userFirstName, String userLastName, String phone, String email, String country,
			String state, String district, String userId, String pwd) {
		this.uId = uId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.phone = phone;
		this.email = email;
		this.country = country;
		this.state = state;
		this.district = district;
		this.userId = userId;
		this.pwd = pwd;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	

}

package com.merryyou.domain;

import com.merryyou.db.BaseEntity;

public class User extends BaseEntity<Integer> {

	private static final long serialVersionUID = 1976097865562936275L;

	private String firstName;
	private String lastName;
	private String gender;
	private String city;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}

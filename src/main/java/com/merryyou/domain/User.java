package com.merryyou.domain;

import com.merryyou.db.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Arrays;
import java.util.Date;

public class User extends BaseEntity<Integer> {

	private static final long serialVersionUID = 1976097865562936275L;

	private String firstName;
	private String lastName;
	private String gender;
	private String city;

	private String startDate;
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date endDate;

	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date[] rangeTime;

	public Date[] getRangeTime() {
		return rangeTime;
	}

	public void setRangeTime(Date[] rangeTime) {
		this.rangeTime = rangeTime;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

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

	@Override
	public String toString() {
		return "User{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", gender='" + gender + '\'' +
				", city='" + city + '\'' +
				", startDate='" + startDate + '\'' +
				", endDate=" + endDate +
				", rangeTime=" + Arrays.toString(rangeTime) +
				'}';
	}
}

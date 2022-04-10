package com.demo;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.demo.validation.email.UniqueEmail;
import com.demo.validation.phonenumber.UniquePhoneNumber;

@Named
@SessionScoped
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5474228161562372212L;

	private Integer id;

	private String name;

	private Date dateOfBirth;

	@UniqueEmail(message = "Email is already existed.")
	private String email;

	@UniquePhoneNumber(message = "Phone number is already existed.")
	private String phoneNumber;

	private Date joinDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Employee() {
	};

	public void setEmployeeAllAttributes(String name, Date dateOfBirth, String email, String phoneNumber,
			Date joinDate) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "Employee [id= " + id + ", name= " + name + ", dateOfBirth= " + dateOfBirth + ", email= " + email
				+ ", phoneNumber= " + phoneNumber + ", joinDate= " + joinDate + "]";
	}

}

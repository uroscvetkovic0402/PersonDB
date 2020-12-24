package com.uros018.dto;

import java.io.Serializable;

import com.uros018.model.DateMap;
import com.uros018.model.SocialNumber;

public class PersonDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7740385487332911366L;
	private int id;
	private String firstName;
	private String lastName;
	private SocialNumber socialNumber;
	private DateMap dateOfBirth;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id; 
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
	public SocialNumber getSocialNumber() {
		return socialNumber;
	}
	public void setSocialNumber(SocialNumber socialNumber) {
		this.socialNumber = socialNumber;
	}
	public DateMap getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(DateMap dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}

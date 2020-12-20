package com.uros018.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String firstName;
	private String lastName;
	private SocialNumber socialNumber;
	private DateMap dateOfBirth;
	private Address address;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@OneToOne
	public SocialNumber getSocialNumber() {
		return socialNumber;
	}
	public void setSocialNumber(SocialNumber socialNumber) {
		this.socialNumber = socialNumber;
	}
	
	@ManyToOne
	public DateMap getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(DateMap dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@ManyToOne
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}

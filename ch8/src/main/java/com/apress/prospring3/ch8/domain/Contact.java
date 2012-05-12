/**
 * Created on Oct 5, 2011
 */
package com.apress.prospring3.ch8.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * @author Clarence
 *
 */
public class Contact implements Serializable {

	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private Date birthDate;
	
	private List<ContactTelDetail> contactTelDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<ContactTelDetail> getContactTelDetails() {
		return contactTelDetails;
	}

	public void setContactTelDetails(List<ContactTelDetail> contactTelDetails) {
		this.contactTelDetails = contactTelDetails;
	}	
	
	public String toString() {		
		return "Contact - Id: " + id + ", First name: " + firstName 
				+ ", Last name: " + lastName + ", Birthday: " + birthDate;
	}
}

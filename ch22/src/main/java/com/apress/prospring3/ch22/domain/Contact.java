/**
 * Created on Jan 16, 2012
 */
package com.apress.prospring3.ch22.domain;

import org.joda.time.DateTime;

/**
 * @author Clarence
 *
 */
public class Contact {

	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private DateTime birthDate;
	
	private String ageCategory;

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

	public DateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(DateTime birthDate) {
		this.birthDate = birthDate;
	}

	public String getAgeCategory() {
		return ageCategory;
	}

	public void setAgeCategory(String ageCategory) {
		this.ageCategory = ageCategory;
	}
	
	public String toString() {		
		return "Contact - Id: " + id + ", First name: " + firstName 
				+ ", Last name: " + lastName + ", Birthday: " + birthDate
				+ ", Age category: " + ageCategory;
	}		
	
}

/**
 * Created on Oct 17, 2011
 */
package com.apress.prospring3.ch10.domain;

import java.io.Serializable;

/**
 * @author Clarence
 *
 */
public class ContactSummary implements Serializable {

	private String firstName;
	
	private String lastName;
	
	private String homeTelNumber;

	public ContactSummary(String firstName, String lastName, String homeTelNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.homeTelNumber = homeTelNumber;
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

	public String getHomeTelNumber() {
		return homeTelNumber;
	}

	public void setHomeTelNumber(String homeTelNumber) {
		this.homeTelNumber = homeTelNumber;
	}
	
	public String toString() {
		return "First name: " + firstName + " Last Name: " + lastName + " Home Phone: " + homeTelNumber;
	}
}

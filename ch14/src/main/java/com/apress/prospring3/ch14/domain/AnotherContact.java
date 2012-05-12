/**
 * Created on Nov 22, 2011
 */
package com.apress.prospring3.ch14.domain;

import java.net.URL;

import org.joda.time.DateTime;

/**
 * @author Clarence
 *
 */
public class AnotherContact {

	private String firstName;
	
	private String lastName;
	
	private DateTime birthDate;
	
	private URL personalSite;

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

	public URL getPersonalSite() {
		return personalSite;
	}

	public void setPersonalSite(URL personalSite) {
		this.personalSite = personalSite;
	}	
	
	public String toString() {
		return "First name: " + getFirstName()
				+ " - Last name: " + getLastName()
				+ " - Birth date: " + getBirthDate()
				+ " - Personal site: " + getPersonalSite();
	}
	
}

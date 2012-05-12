/**
 * Created on Sep 25, 2011
 */
package com.apress.prospring3.ch5.pe;

/**
 * @author Clarence
 *
 */
public class Name {

	private String firstName;
	
	private String lastName;

	public Name() {
	}
	
	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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
	
	public String toString() {
		return "First name: " + firstName + " - Last name: " + lastName;
	}
}

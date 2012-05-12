/**
 * Created on Oct 24, 2011
 */
package com.apress.prospring3.ch11.domain;

import java.io.Serializable;

/**
 * @author Clarence
 *
 */
public class ContactTelDetail implements Serializable {

	private Long id;
	private Contact contact;
	private String telType;
	private String telNumber;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Contact getContact() {
		return contact;
	}
	
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	public String getTelType() {
		return telType;
	}
	
	public void setTelType(String telType) {
		this.telType = telType;
	}
	
	public String getTelNumber() {
		return telNumber;
	}
	
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	
	public String toString() {
		return "Contact Tel Detail - Id: " + id + ", Contact id: " + contact.getId()
				+ ", Type: " + telType + ", Number: " + telNumber;
	}	
	
}

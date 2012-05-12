/**
 * Created on Oct 5, 2011
 */
package com.apress.prospring3.ch8.domain;

import java.io.Serializable;

/**
 * @author Clarence
 *
 */
public class ContactTelDetail implements Serializable {

	private Long id;
	
	private Long contactId;
	
	private String telType;
	
	private String telNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}	
	
	public String toString() {
		return "Contact Tel Detail - Id: " + id + ", Contact id: " + contactId
				+ ", Type: " + telType + ", Number: " + telNumber;
	}
}

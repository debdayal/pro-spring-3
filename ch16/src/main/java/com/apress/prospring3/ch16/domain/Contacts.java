/**
 * Created on Nov 29, 2011
 */
package com.apress.prospring3.ch16.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author Clarence
 *
 */
public class Contacts implements Serializable {

	private List<Contact> contacts;

	public Contacts() {
	}
	
	public Contacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	 
}

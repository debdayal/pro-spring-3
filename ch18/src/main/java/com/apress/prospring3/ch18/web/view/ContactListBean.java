/**
 * Created on Dec 30, 2011
 */
package com.apress.prospring3.ch18.web.view;

import java.io.Serializable;
import java.util.List;

import com.apress.prospring3.ch18.domain.Contact;

/**
 * @author Clarence
 *
 */
public class ContactListBean implements Serializable {

	private List<Contact> contacts;
	
	private Contact selectedContact;

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Contact getSelectedContact() {
		return selectedContact;
	}

	public void setSelectedContact(Contact selectedContact) {
		this.selectedContact = selectedContact;
	}
	
}

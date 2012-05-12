/**
 * Created on Nov 22, 2011
 */
package com.apress.prospring3.ch14.converter;

import org.springframework.core.convert.converter.Converter;

import com.apress.prospring3.ch14.domain.AnotherContact;
import com.apress.prospring3.ch14.domain.Contact;

/**
 * @author Clarence
 *
 */
public class ContactToAnotherContactConverter implements Converter<Contact, AnotherContact> {
	
	public AnotherContact convert(Contact contact) {
		AnotherContact anotherContact = new AnotherContact();
		anotherContact.setFirstName(contact.getLastName());
		anotherContact.setLastName(contact.getFirstName());
		anotherContact.setBirthDate(contact.getBirthDate());
		anotherContact.setPersonalSite(contact.getPersonalSite());
		
		return anotherContact;
	}

}

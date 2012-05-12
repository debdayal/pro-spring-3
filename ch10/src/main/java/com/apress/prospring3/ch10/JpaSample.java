/**
 * Created on Oct 19, 2011
 */
package com.apress.prospring3.ch10;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch10.domain.Contact;
import com.apress.prospring3.ch10.domain.ContactTelDetail;
import com.apress.prospring3.ch10.domain.Hobby;
import com.apress.prospring3.ch10.service.ContactService;

/**
 * @author Clarence
 *
 */
public class JpaSample {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context.xml");
		ctx.refresh();
		
		ContactService contactService = ctx.getBean("jpaContactService", ContactService.class);
		
		// Add new contact
		Contact contact = new Contact();
		contact.setFirstName("Michael");
		contact.setLastName("Jackson");
		contact.setBirthDate(new Date());
		ContactTelDetail contactTelDetail = new ContactTelDetail("Home", "1111111111");
		contact.addContactTelDetail(contactTelDetail);
		contactTelDetail = new ContactTelDetail("Mobile", "2222222222");
		contact.addContactTelDetail(contactTelDetail);
		contactService.save(contact);
		List<Contact> contacts = contactService.findAllWithDetail();
		listContactsWithDetail(contacts);		
	
		// Find contact by ID
		contact = contactService.findById(1l);
		System.out.println("");
		System.out.println("Contact with id 1:" + contact);
		System.out.println("");		
		
		// Update contact
		contact.setFirstName("Kim Fung");
		Set<ContactTelDetail> contactTels = contact.getContactTelDetails();
		ContactTelDetail toDeleteContactTel = null;
		for (ContactTelDetail contactTel: contactTels) {
			if (contactTel.getTelType().equals("Home")) {
				toDeleteContactTel = contactTel;
			}
		}
		contactTels.remove(toDeleteContactTel);
		contactService.save(contact);
		contacts = contactService.findAllWithDetail();
		listContactsWithDetail(contacts);
		
		// Delete contact
		contact = contactService.findById(1l);
		contactService.delete(contact);
		contacts = contactService.findAllWithDetail();
		listContactsWithDetail(contacts);	
		
		// Find contact by native query
		contacts = contactService.findAllByNativeQuery();
		System.out.println("Find all contacts by native query:");
		listContacts(contacts);		
		
		// Find contact by criteria query
		contacts = contactService.findByCriteriaQuery("John", "Smith");
		listContactsWithDetail(contacts);			
		
	}

	private static void listContacts(List<Contact> contacts) {
		System.out.println("");
		System.out.println("Listing contacts without details:");
		for (Contact contact: contacts) {
			System.out.println(contact);		
			System.out.println();	
		}
	}	
	
	private static void listContactsWithDetail(List<Contact> contacts) {
		System.out.println("");
		System.out.println("Listing contacts with details:");
		for (Contact contact: contacts) {
			System.out.println(contact);
			if (contact.getContactTelDetails() != null) {
				for (ContactTelDetail contactTelDetail: contact.getContactTelDetails()) {
					System.out.println(contactTelDetail);
				}
			}
			if (contact.getHobbies() != null) {
				for (Hobby hobby: contact.getHobbies()) {
					System.out.println(hobby);
				}
			}			
			System.out.println();
		}		
	}		
	
}

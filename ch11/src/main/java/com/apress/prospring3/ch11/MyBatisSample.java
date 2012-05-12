/**
 * Created on Oct 25, 2011
 */
package com.apress.prospring3.ch11;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch11.domain.Contact;
import com.apress.prospring3.ch11.domain.ContactTelDetail;
import com.apress.prospring3.ch11.domain.Hobby;
import com.apress.prospring3.ch11.service.ContactService;

/**
 * @author Clarence
 *
 */
public class MyBatisSample {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context.xml");
		ctx.refresh();
		
		ContactService contactService = ctx.getBean("contactService", ContactService.class);

		List<Contact> contacts;
		
		// Find all contacts
		contacts = contactService.findAll();
		listContacts(contacts);	
		
		// Find all contacts with details
		contacts = contactService.findAllWithDetail();
		listContactsWithDetail(contacts);	
		
		// Find contact by id
		contacts = new ArrayList<Contact>();
		System.out.println("Finding contact with id 1");
		Contact contact = contactService.findById(1l);
		contacts.add(contact);
		listContactsWithDetail(contacts);	
		
		// Find contact by first name and last name
		contacts = contactService.findByFirstNameAndLastName("Clarence", "Ho");
		listContactsWithDetail(contacts);	
		
		// Add new contact
		System.out.println("Add new contact");
		contact = new Contact();
		contact.setFirstName("Michael");
		contact.setLastName("Jackson");
		contact.setBirthDate(new Date());
		Set<ContactTelDetail> contactTelDetails = new HashSet<ContactTelDetail>();
		ContactTelDetail contactTelDetail = new ContactTelDetail();
		contactTelDetail.setTelType("Home");
		contactTelDetail.setTelNumber("111111");
		contactTelDetails.add(contactTelDetail);
		contactTelDetail = new ContactTelDetail();	
		contactTelDetail.setTelType("Mobile");
		contactTelDetail.setTelNumber("222222");
		contactTelDetails.add(contactTelDetail);	
		contact.setContactTelDetails(contactTelDetails);
		Set<Hobby> hobbies = new HashSet<Hobby>();
		Hobby hobby = new Hobby();
		hobby.setHobbyId("Jogging");
		hobbies.add(hobby);		
		contact.setHobbies(hobbies);
		contactService.save(contact);
		contacts = contactService.findAllWithDetail();
		listContactsWithDetail(contacts);
		
		// Update contact
		System.out.println("Update contact with id 1");
		contact = contactService.findById(1l);		
		contact.setFirstName("Kim Fung");
		Set<ContactTelDetail> contactTels = contact.getContactTelDetails();
		ContactTelDetail toDeleteContactTel = null;
		for (ContactTelDetail contactTel: contactTels) {
			if (contactTel.getTelType().equals("Home")) {
				toDeleteContactTel = contactTel;
			}
		}
		contactTels.remove(toDeleteContactTel);
		hobby = new Hobby();
		hobby.setHobbyId("Jogging");
		contact.getHobbies().add(hobby);
		contactService.save(contact);
		contacts = contactService.findAllWithDetail();
		listContactsWithDetail(contacts);			

		// Delete contact
		System.out.println("Delete contact with id 1");
		contact = contactService.findById(1l);
		contactService.delete(contact);
		contacts = contactService.findAllWithDetail();
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

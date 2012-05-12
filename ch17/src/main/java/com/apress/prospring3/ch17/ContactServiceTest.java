/**
 * Created on Dec 21, 2011
 */
package com.apress.prospring3.ch17;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch17.domain.Contact;
import com.apress.prospring3.ch17.service.ContactService;

/**
 * @author Clarence
 *
 */
public class ContactServiceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:jpa-app-context.xml");
		ctx.refresh();
		
		System.out.println("App context initialized successfully");
		
		ContactService contactService = ctx.getBean("contactService", ContactService.class);
		
		List<Contact> contacts = contactService.findAll();
		
		for (Contact contact: contacts) {
			System.out.println(contact);
		}

	}

}

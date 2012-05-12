/**
 * Created on Nov 7, 2011
 */
package com.apress.prospring3.ch13;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch13.domain.Contact;
import com.apress.prospring3.ch13.service.ContactService;

/**
 * @author Clarence
 *
 */
public class TxAnnotationSample {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:tx-annotation-app-context.xml");
		ctx.refresh();
		
		ContactService contactService = ctx.getBean("contactService", ContactService.class);

		// Testing findAll() method
/*		List<Contact> contacts = contactService.findAll();
		
		for (Contact contactTemp: contacts) {
			System.out.println(contactTemp);
		}	*/	
		
		// Testing save() method
/*		Contact contact = contactService.findById(1l);
		contact.setFirstName("Peter");
		contactService.save(contact);
		System.out.println("Contact saved successfully");	*/
		
		// Testing countAll() method
		System.out.println("Contact count: " + contactService.countAll());		
		
	}

}

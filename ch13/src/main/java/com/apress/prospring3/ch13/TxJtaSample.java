/**
 * Created on Nov 7, 2011
 */
package com.apress.prospring3.ch13;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch13.domain.Contact;
import com.apress.prospring3.ch13.service.ContactService;

/**
 * @author Clarence
 *
 */
public class TxJtaSample {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:tx-jta-app-context.xml");
		ctx.refresh();
		
		ContactService contactService = ctx.getBean("contactService", ContactService.class);

		Contact contact = new Contact();
		contact.setFirstName("Jta");
		contact.setLastName("Manager");
		contactService.save(contact);
		System.out.println("Contact saved successfully");		
		
	}

}

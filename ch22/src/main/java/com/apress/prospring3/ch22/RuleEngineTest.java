/**
 * Created on Jan 16, 2012
 */
package com.apress.prospring3.ch22;

import org.joda.time.format.DateTimeFormat;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch22.domain.Contact;
import com.apress.prospring3.ch22.service.ContactService;

/**
 * @author Clarence
 *
 */
public class RuleEngineTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context.xml");
		ctx.refresh();
		
		ContactService contactService = ctx.getBean("contactService", ContactService.class);
		
		// Construct Contact object
		Contact contact = new Contact();
		contact.setId(1l);
		contact.setFirstName("Clarence");
		contact.setLastName("Ho");
		contact.setBirthDate(DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime("1980-08-09"));

		// Apply rule to contact object
		contactService.applyRule(contact);
		System.out.println("Contact: " + contact);
		
		// Wait for rule to be updated
		try {
			System.in.read();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		// Apply the rule again
		contactService.applyRule(contact);	
		System.out.println("Contact: " + contact);		
		
	}

}

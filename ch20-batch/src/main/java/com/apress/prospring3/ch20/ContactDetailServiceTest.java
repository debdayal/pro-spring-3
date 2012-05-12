/**
 * Created on Dec 21, 2011
 */
package com.apress.prospring3.ch20;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch20.domain.Contact;
import com.apress.prospring3.ch20.domain.Hobby;
import com.apress.prospring3.ch20.service.ContactService;

/**
 * @author Clarence
 *
 */
public class ContactDetailServiceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context.xml");
		ctx.refresh();
		
		System.out.println("App context initialized successfully");
		
		ContactService contactService = ctx.getBean("contactService", ContactService.class);
		
		Contact contact = contactService.findByIdWithDetail(1l);	
		//Contact contact = contactService.findById(1l);
		
		System.out.println(contact);
		for (Hobby hobby: contact.getHobbies()) {
			System.out.println(hobby.getHobbyId());
		}
		
	}

}

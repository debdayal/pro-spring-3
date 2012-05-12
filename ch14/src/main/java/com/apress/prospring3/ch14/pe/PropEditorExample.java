/**
 * Created on Nov 20, 2011
 */
package com.apress.prospring3.ch14.pe;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch14.domain.Contact;

/**
 * @author Clarence
 *
 */
public class PropEditorExample {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:prop-editor-app-context.xml");
		ctx.refresh();
		
		Contact clarence = ctx.getBean("clarence", Contact.class);
		
		System.out.println("Clarence info: " + clarence);
		
		Contact myContact = ctx.getBean("myContact", Contact.class);
		
		System.out.println("My contact info: " + myContact);
	}

}

/**
 * Created on Nov 7, 2011
 */
package com.apress.prospring3.ch13;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch13.service.ContactService;

/**
 * @author Clarence
 *
 */
public class TxProgrammaticSample {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:tx-programmatic-app-context.xml");
		ctx.refresh();
		
		ContactService contactService = ctx.getBean("contactService", ContactService.class);
		
		System.out.println("Contact count: " + contactService.countAll());

	}

}

/**
 * Created on Nov 22, 2011
 */
package com.apress.prospring3.ch14.convserv;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.convert.ConversionService;

import com.apress.prospring3.ch14.domain.Contact;

/**
 * @author Clarence
 *
 */
public class ConvFormatServExample {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:conv-format-service-app-context.xml");
		ctx.refresh();
		
		Contact clarence = ctx.getBean("clarence", Contact.class);
		
		System.out.println("Contact info: " + clarence);
		
		ConversionService conversionService = ctx.getBean("conversionService", ConversionService.class);
		System.out.println("Birthdate of contact is : " + conversionService.convert(clarence.getBirthDate(), String.class));	
		
	}	
	
}

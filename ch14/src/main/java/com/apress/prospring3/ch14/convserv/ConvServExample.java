/**
 * Created on Nov 22, 2011
 */
package com.apress.prospring3.ch14.convserv;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.convert.ConversionService;

import com.apress.prospring3.ch14.domain.AnotherContact;
import com.apress.prospring3.ch14.domain.Contact;

/**
 * @author Clarence
 *
 */
public class ConvServExample {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:conv-service-app-context.xml");
		ctx.refresh();
		
		Contact clarence = ctx.getBean("clarence", Contact.class);
		
		System.out.println("Contact info: " + clarence);
		
		ConversionService conversionService = ctx.getBean(ConversionService.class);
		
		// Convert from Contact to AnotherContact
		AnotherContact anotherContact = conversionService.convert(clarence, AnotherContact.class);
		System.out.println("Another contact info: " + anotherContact);
		
		// Conversion from String to Array
		String[] stringArray = conversionService.convert("a,b,c", String[].class);
		System.out.println("String array: " + stringArray[0] + stringArray[1] + stringArray[2]);
		
		// Conversion from List to Set
		List<String> listString = new ArrayList<String>();
		listString.add("a");
		listString.add("b");
		listString.add("c");
		Set<String> setString = conversionService.convert(listString, HashSet.class);
		for (String string: setString)
			System.out.println("Set: " + string);
		
	}	
	
}

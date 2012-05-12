/**
 * Created on Sep 26, 2011
 */
package com.apress.prospring3.ch5.env;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Clarence
 *
 */
public class PlaceHolderSample {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:env/env.xml");
		ctx.refresh();
		
		AppProperty appProperty = ctx.getBean("appProperty", AppProperty.class);
		
		System.out.println("application.home: " + appProperty.getApplicationHome());
		System.out.println("user.home: " + appProperty.getUserHome());	
	}

}

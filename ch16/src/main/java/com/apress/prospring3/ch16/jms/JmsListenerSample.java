/**
 * Created on Nov 25, 2011
 */
package com.apress.prospring3.ch16.jms;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Clarence
 *
 */
public class JmsListenerSample {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:jms-listener-app-context.xml");
		ctx.refresh();
		
		while (true) {
		}

	}

}

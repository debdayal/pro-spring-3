/**
 * Created on Dec 21, 2011
 */
package com.apress.prospring3.ch20;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Clarence
 *
 */
public class BatchIntegrationTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context.xml");
		ctx.refresh();
		
		System.out.println("App context initialized successfully");

		while (true) {
		}
	}

}

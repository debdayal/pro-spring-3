/**
 * Created on Sep 11, 2011
 */
package com.apress.prospring3.ch2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Clarence
 *
 */
public class HelloWorldSpringDI {

	public static void main(String[] args) {

		// Initialize Spring application context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");
		
		MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
		mr.render();
		
	}

}

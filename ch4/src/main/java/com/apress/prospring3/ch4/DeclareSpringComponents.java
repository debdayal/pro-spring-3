/**
 * Created on Sep 20, 2011
 */
package com.apress.prospring3.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Clarence
 *
 */
public class DeclareSpringComponents {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context-xml.xml");
		//ctx.load("classpath:app-context-annotation.xml");
		ctx.refresh();		
		
		MessageProvider messageProvider = ctx.getBean("messageProvider", MessageProvider.class);

		System.out.println(messageProvider.getMessage());
	}

}

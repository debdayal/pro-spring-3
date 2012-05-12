/**
 * Created on Nov 21, 2011
 */
package com.apress.prospring3.ch15.schedule;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Clarence
 *
 */
public class ScheduleTaskAnnotationSample {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:task-annotation-app-context.xml");
		ctx.refresh();
		
		while (true) {			
		}
	}

}

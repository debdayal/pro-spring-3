/**
 * Created on Sep 26, 2011
 */
package com.apress.prospring3.ch5.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Clarence
 *
 */
public class JavaConfigSimpleExample {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");
		
		MessageRenderer renderer = ctx.getBean("messageRenderer", MessageRenderer.class);
		
		renderer.render();

	}

}

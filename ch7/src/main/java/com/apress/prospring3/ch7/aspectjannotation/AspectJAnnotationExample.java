/**
 * Created on Oct 3, 2011
 */
package com.apress.prospring3.ch7.aspectjannotation;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Clarence
 *
 */
public class AspectJAnnotationExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:aspectjannotation.xml");
		ctx.refresh();
		
		MyBean myBean = (MyBean) ctx.getBean("myBean");
		myBean.execute();		

	}

}

/**
 * Created on Oct 2, 2011
 */
package com.apress.prospring3.ch7.aopns;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Clarence
 *
 */
public class AopNamespaceExample {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:aopns.xml");
		ctx.refresh();
		
		MyBean myBean = (MyBean) ctx.getBean("myBean");
		myBean.execute();
	}

}

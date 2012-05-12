/**
 * Created on Sep 22, 2011
 */
package com.apress.prospring3.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Clarence
 *
 */
public class NonSingleton {

	public static void main(String[] args) {

    	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context-xml.xml");
		ctx.refresh();
        
        String s1 = (String) ctx.getBean("nonSingleton");
        String s2 = (String) ctx.getBean("nonSingleton");
        
        System.out.println("Identity Equal?: " + (s1 ==s2));
        System.out.println("Value Equal:? " + s1.equals(s2));
        System.out.println(s1);
        System.out.println(s2);		
	}

}

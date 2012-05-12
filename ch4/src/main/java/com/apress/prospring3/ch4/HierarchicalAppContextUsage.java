/**
 * Created on Sep 21, 2011
 */
package com.apress.prospring3.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Clarence
 *
 */
public class HierarchicalAppContextUsage {

	public static void main(String[] args) {

    	GenericXmlApplicationContext parent = new GenericXmlApplicationContext();
    	parent.load("classpath:parent.xml");
    	parent.refresh();   			
		
    	GenericXmlApplicationContext child = new GenericXmlApplicationContext();
    	child.load("classpath:app-context-xml.xml");
    	child.setParent(parent);
    	child.refresh();   		

        SimpleTarget target1 = (SimpleTarget) child.getBean("target1");
        SimpleTarget target2 = (SimpleTarget) child.getBean("target2");
        SimpleTarget target3 = (SimpleTarget) child.getBean("target3");

        System.out.println(target1.getVal());
        System.out.println(target2.getVal());
        System.out.println(target3.getVal());    	
    	
	}

}

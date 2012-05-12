/*
 * Created on Sep 25, 2011
 */
package com.apress.prospring3.ch5.interaction;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch5.lifecycle.DestructiveBeanWithInterface;

/**
 * @author clarence
 */
public class ShutdownHookBeanExample {

    public static void main(String[] args) {
    	
    	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    	ctx.load("interaction/shutdownHook.xml");
    	ctx.refresh();
    	
        DestructiveBeanWithInterface bean = (DestructiveBeanWithInterface) ctx.getBean("destructiveBean");
    }
}
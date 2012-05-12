/*
 * Created on Sep 25, 2011
 */
package com.apress.prospring3.ch5.factory;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author clarence
 */
public class MessageDigestExample {

    public static void main(String[] args) {
    	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    	ctx.load("classpath:factory/factory.xml");
    	ctx.refresh();    	

        MessageDigester digester = (MessageDigester) ctx.getBean("digester");
        digester.digest("Hello World!");

    }
}
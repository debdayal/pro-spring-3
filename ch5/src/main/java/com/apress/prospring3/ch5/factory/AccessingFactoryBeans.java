/*
 * Created on Sep 25, 2011
 */
package com.apress.prospring3.ch5.factory;

import java.security.MessageDigest;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author clarence
 */
public class AccessingFactoryBeans {

    public static void main(String[] args) {
    	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    	ctx.load("classpath:factory/factory.xml");
    	ctx.refresh();     	
    	
        MessageDigest digest = (MessageDigest) ctx.getBean("shaDigest");
        
        MessageDigestFactoryBean factoryBean = (MessageDigestFactoryBean) ctx.getBean("&shaDigest");
        
        try {
        	MessageDigest shaDigest = factoryBean.getObject();        	
        	System.out.println(shaDigest.digest("Hello world".getBytes()));
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
    }
}
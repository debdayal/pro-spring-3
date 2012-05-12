/*
 * Created on Sep 25, 2011
 */
package com.apress.prospring3.ch5.interaction;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author clarence
 */
public class LoggingBeanExample {

    public static void main(String[] args) {
    	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    	ctx.load("classpath:interaction/logging.xml");
    	ctx.refresh();
        
        LoggingBean bean = (LoggingBean) ctx.getBean("loggingBean");
        bean.someOperation();
    }
}
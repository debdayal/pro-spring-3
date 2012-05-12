/*
 * Created on Sep 26, 2011
 */
package com.apress.prospring3.ch5.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author clarence
 */
public class Publisher implements ApplicationContextAware {

    private ApplicationContext ctx;

    public static void main(String[] args) {
    	   	
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "classpath:events/events.xml");

        Publisher pub = (Publisher) ctx.getBean("publisher");
        pub.publish("Hello World!");
        pub.publish("The quick brown fox jumped over the lazy dog");
    }

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.ctx = applicationContext;

    }

    public void publish(String message) {
        ctx.publishEvent(new MessageEvent(this, message));
    }
}
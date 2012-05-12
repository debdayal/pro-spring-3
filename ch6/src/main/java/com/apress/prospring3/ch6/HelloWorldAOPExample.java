/*
 * Created on Sep 30, 2011
 */
package com.apress.prospring3.ch6;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author clarence
 */
public class HelloWorldAOPExample {

    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();
        
        // create the proxy
        ProxyFactory pf = new ProxyFactory();

        pf.addAdvice(new MessageDecorator());
        pf.setTarget(target);


        MessageWriter proxy = (MessageWriter) pf.getProxy();
        
        // write the messages
        target.writeMessage();
        System.out.println("");
        proxy.writeMessage();
    }
}
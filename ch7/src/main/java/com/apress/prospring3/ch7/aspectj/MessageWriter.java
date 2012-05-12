/*
 * Created on Sep 9, 2011
 */
package com.apress.prospring3.ch7.aspectj;

/**
 * @author clarence
 */
public class MessageWriter {

    public void writeMessage() {
        System.out.println("foobar!");
    }
    
    public void foo() {
        System.out.println("foo");
    }
}

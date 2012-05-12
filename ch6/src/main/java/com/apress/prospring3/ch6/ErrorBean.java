/*
 * Created on Sep 30, 2011
 */
package com.apress.prospring3.ch6;

/**
 * @author clarence
 */
public class ErrorBean {

    public void errorProneMethod() throws Exception {
        throw new Exception("Foo");
    }

    public void otherErrorProneMethod() throws IllegalArgumentException {
        throw new IllegalArgumentException("Bar");
    }
}
/*
 * Created on Sep 25, 2011
 */
package com.apress.prospring3.ch5.factory;

import java.security.MessageDigest;

/**
 * @author clarence
 */
public class MessageDigestFactory {

    private String algorithmName = "MD5";
    
    public MessageDigest createInstance() throws Exception {
       return MessageDigest.getInstance(algorithmName);
    }
    
    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

}

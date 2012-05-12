/*
 * Created on Sep 25, 2011
 */
package com.apress.prospring3.ch5.factory;

import java.security.MessageDigest;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author clarence
 */
public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>, InitializingBean {

    private String algorithmName = "MD5";
    
    private MessageDigest messageDigest = null;

    public MessageDigest getObject() throws Exception {
       return messageDigest;
    }


    public Class<MessageDigest> getObjectType() {
       return MessageDigest.class;
    }


    public boolean isSingleton() {
       return true;
    }

    public void afterPropertiesSet() throws Exception {
        messageDigest = MessageDigest.getInstance(algorithmName);
    }
    
    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

}

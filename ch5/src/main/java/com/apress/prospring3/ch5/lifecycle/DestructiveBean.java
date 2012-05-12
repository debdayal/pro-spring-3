/*
 * Created on Sep 25, 2011
 */
package com.apress.prospring3.ch5.lifecycle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author clarence
 */
public class DestructiveBean implements InitializingBean {

    private InputStream is = null;

    public String filePath = null;

    public void afterPropertiesSet() throws Exception {

        System.out.println("Initializing Bean");

        if (filePath == null) {
            throw new IllegalArgumentException(
                    "You must specify the filePath property of " + DestructiveBean.class);
        }

        is = new FileInputStream(filePath);
    }

    public void destroy() {

        System.out.println("Destroying Bean");

        if (is != null) {
            try {
                is.close();
                is = null;
            } catch (IOException ex) {
                System.err.println("WARN: An IOException occured"
                        + " trying to close the InputStream");
            }
        }
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String[] args) throws Exception {
    	
    	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    	ctx.load("classpath:lifecycle/disposeMethod.xml");
    	ctx.refresh(); // Refresh the ApplicationContext after XML config file loaded

        DestructiveBean bean = (DestructiveBean) ctx.getBean("destructiveBean");
        
        System.out.println("Calling destroy()");
        ctx.destroy(); 
        System.out.println("Called destroy()");
    }
}
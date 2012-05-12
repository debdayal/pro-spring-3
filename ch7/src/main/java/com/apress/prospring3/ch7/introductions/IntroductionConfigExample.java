/*
 * Created on Oct 9, 2011
 */
package com.apress.prospring3.ch7.introductions;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author clarence
 */
public class IntroductionConfigExample {

    public static void main(String[] args) {
    	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    	ctx.load("classpath:introductions.xml");
    	ctx.refresh();

        TargetBean bean = (TargetBean) ctx.getBean("bean");
        IsModified mod = (IsModified) bean;

        // test interfaces
        System.out.println("Is TargetBean?: " + (bean instanceof TargetBean));
        System.out.println("Is IsModified?: " + (bean instanceof IsModified));

        // test is modified implementation
        System.out.println("Has been modified?: " + mod.isModified());
        bean.setName("Clarence Ho");
        System.out.println("Has been modified?: " + mod.isModified());
        bean.setName("Rob Harrop");
        System.out.println("Has been modified?: " + mod.isModified());
    }
}
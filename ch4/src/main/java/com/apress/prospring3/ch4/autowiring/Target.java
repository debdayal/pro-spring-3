/*
 * Created on Sep 22, 2011
 */
package com.apress.prospring3.ch4.autowiring;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author clarence
 */
public class Target {

    private Foo foo;
    private Foo foo2;
    
    private Bar bar;

    public Target() {
    }
    
    public Target(Foo foo) {
        System.out.println("Target(Foo) called");
    }
    
    public Target(Foo foo, Bar bar) {
        System.out.println("Target(Foo, Bar) called");
    }
    
    public void setFoo(Foo foo) {
        this.foo = foo;
        System.out.println("Property foo set");
    }
    
    public void setFoo2(Foo foo) {
        this.foo2 = foo;
        System.out.println("Property foo2 set");
    }

    public void setBar(Bar bar) {
        this.bar = bar;
        System.out.println("Property bar set");
    }

    public static void main(String[] args) {
    	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:autowiring.xml");
		ctx.refresh();

        Target t = null;
        
        System.out.println("Using byName:\n");
        t = (Target) ctx.getBean("targetByName");
        
        System.out.println("\nUsing byType:\n");
        t = (Target) ctx.getBean("targetByType");
        
        System.out.println("\nUsing constructor:\n");
        t = (Target) ctx.getBean("targetConstructor");
        
    }
}
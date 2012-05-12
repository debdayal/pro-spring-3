/*
 * Created on 22-Sep-2011
 */
package com.apress.prospring3.ch4.inheritance;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author clarence
 */
public class SimpleBean {

    public String name;

    public int age;
    
    public static void main(String[] args) {
    	
    	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    	ctx.load("classpath:app-context-xml.xml");
        
        SimpleBean parent = (SimpleBean) ctx.getBean("inheritParent");
        SimpleBean child = (SimpleBean) ctx.getBean("inheritChild");
        
        System.out.println("Parent:\n" + parent);
        System.out.println("Child:\n" + child);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
        
    public String toString() {
        return    "Name: " + name + "\n"
                + "Age: " + age;
    }
}
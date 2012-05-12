/**
 * Created on Sep 21, 2011
 */
package com.apress.prospring3.ch4.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Clarence
 *
 */
public class InjectSimple {

    private String name;

    private int age;

    private float height;

    private boolean programmer;

    private Long ageInSeconds;

    public static void main(String[] args) {

    	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context-xml.xml");
		ctx.refresh();    	
    	
        InjectSimple simple = (InjectSimple)ctx.getBean("injectSimple");
        ctx.getBean("injectRef");
        System.out.println(simple);
    }

    public void setAgeInSeconds(Long ageInSeconds) {
        this.ageInSeconds = ageInSeconds;
    }

    public void setProgrammer(boolean programmer) {
        this.programmer = programmer;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return    "Name :" + name + "\n"
                + "Age:" + age + "\n"
                + "Age in Seconds: " + ageInSeconds + "\n"
                + "Height: " + height + "\n"
                + "Is Programmer?: " + programmer;
    }	
	
}

/**
 * Created on Sep 21, 2011
 */
package com.apress.prospring3.ch4.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author Clarence
 *
 */
@Service("injectSimple")
public class InjectSimple {

	@Value("John Smith")
    private String name;

	@Value("35")
    private int age;

	@Value("1.78")
    private float height;

	@Value("true")
    private boolean programmer;

	@Value("1103760000")
    private Long ageInSeconds;

    public static void main(String[] args) {

    	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context-annotation.xml");
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

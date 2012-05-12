/*
 * Created on Sep 25, 2011
 */
package com.apress.prospring3.ch5.pe;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author clarence
 */
public class CustomEditorExample {

	private Name name;

    public static void main(String[] args) {
    	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    	ctx.load("classpath:pe/custom.xml");
    	ctx.refresh();

        CustomEditorExample bean = (CustomEditorExample) ctx.getBean("exampleBean");

        System.out.println(bean.getName());
    }

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}
}
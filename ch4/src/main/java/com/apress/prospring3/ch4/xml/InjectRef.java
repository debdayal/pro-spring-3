/**
 * Created on Sep 21, 2011
 */
package com.apress.prospring3.ch4.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch4.Oracle;


/**
 * @author Clarence
 *
 */
public class InjectRef {

    private Oracle oracle;
    
    public void setOracle(Oracle oracle) {
        this.oracle = oracle;
    }	
	
    public static void main(String[] args) {

    	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context-xml.xml");
		ctx.refresh();    	
    	
        InjectRef injectRef = (InjectRef) ctx.getBean("injectRef");
        System.out.println(injectRef);
    }    
    
    public String toString() {
    	return oracle.defineMeaningOfLife();
    }
    
}

/*
 * Created on Oct 8, 2011
 */
package com.apress.prospring3.ch7.aspectjannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author clarence
 */
@Component("myBean")
public class MyBean {

    private MyDependency myDependency;
    
    public void execute() {
    	myDependency.foo(100);
    	myDependency.foo(101);
    	myDependency.bar();
    }
    
    @Autowired
    public void setDep(MyDependency myDependency) {
        this.myDependency = myDependency;
    }
}

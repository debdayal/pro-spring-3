/*
 * Created on Oct 8, 2011
 */
package com.apress.prospring3.ch7.pfb;

/**
 * @author clarence
 */
public class MyBean {

    private MyDependency dep;
    
    public void execute() {
        dep.foo();
        dep.bar();
    }
    
    public void setDep(MyDependency dep) {
        this.dep = dep;
    }
}

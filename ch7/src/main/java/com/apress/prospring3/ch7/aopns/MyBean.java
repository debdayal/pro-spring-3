/*
 * Created on Oct 8, 2011
 */
package com.apress.prospring3.ch7.aopns;

/**
 * @author clarence
 */
public class MyBean {

    private MyDependency dep;
    
    public void execute() {
        dep.foo(100);
        dep.foo(101);
        dep.bar();
    }
    
    public void setDep(MyDependency dep) {
        this.dep = dep;
    }
}

/*
 * Created on Sep 30, 2011
 */
package com.apress.prospring3.ch6.annotationpc;

/**
 * @author clarence
 */
public class SampleAnnotationBean {

	@AdviceRequired
    public void foo(int x) {
        System.out.println("Invoked foo() with: "  +x);
    }
    
    public void bar() { 
        System.out.println("Invoked bar()");
    }
}

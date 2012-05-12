/*
 * Created on Sep 9, 2011
 */
package com.apress.prospring3.ch7.aspectj;

/** 
 * @author clarence
 */
public aspect MessageWrapper {

    private String prefix;
    private String suffix;
    
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }   
    
    pointcut doWriting() : 
        execution(* 
           com.apress.prospring3.ch7.aspectj.MessageWriter.writeMessage());
    
    before() : doWriting() {
        System.out.println(prefix);
    }
    
    after() : doWriting() {
        System.out.println(suffix);
    }
}

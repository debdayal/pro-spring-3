/*
 * Created on Sep 30, 2011
 */
package com.apress.prospring3.ch6.profiling;

/**
 * @author clarence
 */
public class WorkerBean {

    public void doSomeWork(int noOfTimes) {
        for(int x = 0; x < noOfTimes; x++) {
            work();
        }
    }
    
    private void work() {
        System.out.print("");
    }
}

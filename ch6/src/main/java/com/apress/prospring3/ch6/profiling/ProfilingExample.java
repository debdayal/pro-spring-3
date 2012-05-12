/*
 * Created on Sep 30, 2011
 */
package com.apress.prospring3.ch6.profiling;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author clarence
 */
public class ProfilingExample {

    public static void main(String[] args) {
        WorkerBean bean = getWorkerBean();
        bean.doSomeWork(10000000);
    }
    
    private static WorkerBean getWorkerBean() {
        WorkerBean target = new WorkerBean();
        
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(new ProfilingInterceptor());
        
        return (WorkerBean)factory.getProxy();
    }
}

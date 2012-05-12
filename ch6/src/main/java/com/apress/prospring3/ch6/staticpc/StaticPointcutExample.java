/*
 * Created on Sep 30, 2011
 */
package com.apress.prospring3.ch6.staticpc;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @author clarence
 */
public class StaticPointcutExample {

    public static void main(String[] args) {
        BeanOne one = new BeanOne();
        BeanTwo two = new BeanTwo();
        
        BeanOne proxyOne;
        BeanTwo proxyTwo;
        
        // create pointcut, advice and advisor
        Pointcut pc = new SimpleStaticPointcut();
        Advice advice = new SimpleAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pc, advice);
        
        // create BeanOne proxy
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(one);
        proxyOne = (BeanOne)pf.getProxy();
        
        // create BeanTwo proxy
        pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(two);
        proxyTwo = (BeanTwo)pf.getProxy();
        
        proxyOne.foo();
        proxyTwo.foo();
        
        proxyOne.bar();
        proxyTwo.bar();
        
    }
}

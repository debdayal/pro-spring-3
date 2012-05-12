/*
 * Created on Sep 30, 2011
 */
package com.apress.prospring3.ch6.namepc;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

import com.apress.prospring3.ch6.staticpc.SimpleAdvice;

/**
 * @author clarence
 */
public class NamePointcutUsingAdvisor {

    public static void main(String[] args) {
        NameBean target = new NameBean();

        // create advisor
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor(
                new SimpleAdvice());
        advisor.addMethodName("foo");
        advisor.addMethodName("bar");

        // create the proxy
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        NameBean proxy = (NameBean) pf.getProxy();

        proxy.foo();
        proxy.foo(999);
        proxy.bar();
        proxy.yup();
    }
}
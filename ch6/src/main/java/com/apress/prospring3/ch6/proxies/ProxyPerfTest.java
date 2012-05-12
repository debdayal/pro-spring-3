/*
 * Created on Sep 30, 2011
 */
package com.apress.prospring3.ch6.proxies;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @author clarence
 */
public class ProxyPerfTest {

    public static void main(String[] args) {
        ISimpleBean target = new SimpleBean();

        Advisor advisor = new DefaultPointcutAdvisor(new TestPointcut(),
                new NoOpBeforeAdvice());

        runCglibTests(advisor, target);
        runCglibFrozenTests(advisor, target);
        runJdkTests(advisor, target);
    }

    private static void runCglibTests(Advisor advisor, ISimpleBean target) {
        ProxyFactory pf = new ProxyFactory();
        pf.setProxyTargetClass(true);
        pf.setTarget(target);
        pf.addAdvisor(advisor);
             
        ISimpleBean proxy = (ISimpleBean)pf.getProxy();
        System.out.println("Running CGLIB (Standard) Tests");
        test(proxy);
    }
    
    private static void runCglibFrozenTests(Advisor advisor, ISimpleBean target) {
        ProxyFactory pf = new ProxyFactory();
        pf.setProxyTargetClass(true);      
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        pf.setFrozen(true);
        
        ISimpleBean proxy = (ISimpleBean)pf.getProxy();
        System.out.println("Running CGLIB (Frozen) Tests");
        test(proxy);
    }
    
    private static void runJdkTests(Advisor advisor, ISimpleBean target) {
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        pf.setInterfaces(new Class[]{ISimpleBean.class});
        
        ISimpleBean proxy = (ISimpleBean)pf.getProxy();
        System.out.println("Running JDK Tests");
        test(proxy);
    }
    
    private static void test(ISimpleBean bean) {
        long before = 0;
        long after = 0;
        
        // Test 1: test advised method
        System.out.println("Testing Advised Method");
        before = System.currentTimeMillis();
        for(int x = 0; x < 500000; x++) {
            bean.advised();
        }
        after = System.currentTimeMillis();;
        
        System.out.println("Took " + (after - before) + " ms");
        
        // Test 2: testing unadvised method
        System.out.println("Testing Unadvised Method");
        before = System.currentTimeMillis(); 
        for(int x = 0; x < 500000; x++) {
            bean.unadvised();
        }
        after = System.currentTimeMillis();;
        
        System.out.println("Took " + (after - before) + " ms");
        
        // Test 3: testing equals() method
        System.out.println("Testing equals() Method");
        before = System.currentTimeMillis(); 
        for(int x = 0; x < 500000; x++) {
            bean.equals(bean);
        }
        after = System.currentTimeMillis();;
        
        System.out.println("Took " + (after - before) + " ms");
        
        // Test 4: testing hashCode() method
        System.out.println("Testing hashCode() Method");
        before = System.currentTimeMillis(); 
        for(int x = 0; x < 500000; x++) {
            bean.hashCode();
        }
        after = System.currentTimeMillis();;
        
        System.out.println("Took " + (after - before) + " ms");
        
        // Test 5: testing method on Advised
        Advised advised = (Advised)bean;
        
        System.out.println("Testing Advised.getProxyTargetClass() Method");
        before = System.currentTimeMillis(); 
        for(int x = 0; x < 500000; x++) {
            advised.getTargetClass();
        }
        after = System.currentTimeMillis();;
        
        System.out.println("Took " + (after - before) + " ms");
        
        System.out.println(">>>\n");
    }
}
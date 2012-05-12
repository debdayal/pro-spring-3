/*
 * Created on Oct 8, 2011
 */
package com.apress.prospring3.ch7.pfb;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * @author clarence
 */
public class MyAdvice implements MethodBeforeAdvice {

    public void before(Method method, Object[] args, Object target)
            throws Throwable {
        System.out.println("Executing: " + method);
    }

}

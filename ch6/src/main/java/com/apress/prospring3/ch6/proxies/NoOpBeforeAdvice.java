/*
 * Created on Sep 30, 2011
 */
package com.apress.prospring3.ch6.proxies;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * @author clarence
 */
public class NoOpBeforeAdvice implements MethodBeforeAdvice {

    public void before(Method method, Object[] args, Object target) throws Throwable {
        // no-op
    }
}

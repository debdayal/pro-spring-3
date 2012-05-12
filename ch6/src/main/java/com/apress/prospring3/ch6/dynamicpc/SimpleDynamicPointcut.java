/*
 * Created on Sep 30, 2011
 */
package com.apress.prospring3.ch6.dynamicpc;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

/**
 * @author clarence
 */
public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {

    public boolean matches(Method method, Class<?> cls) {
        System.out.println("Static check for " + method.getName());
        return ("foo".equals(method.getName()));
    }

    public boolean matches(Method method, Class<?> cls, Object[] args) {
        System.out.println("Dynamic check for " + method.getName());

        int x = ((Integer) args[0]).intValue();

        return (x != 100);
    }

    public ClassFilter getClassFilter() {
        return new ClassFilter() {

            public boolean matches(Class<?> cls) {
                return (cls == SampleBean.class);
            }
        };
    }
}
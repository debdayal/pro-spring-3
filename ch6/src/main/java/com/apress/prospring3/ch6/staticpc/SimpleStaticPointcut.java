/*
 * Created on Sep 30, 2011
 */
package com.apress.prospring3.ch6.staticpc;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

/**
 * @author clarence
 */
public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {
	
    public boolean matches(Method method, Class<?> cls) {
        return ("foo".equals(method.getName()));
    }

	public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class<?> cls) {
                return (cls == BeanOne.class);
            }
        };

    }
}
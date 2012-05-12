/*
 * Created on Sep 30, 2011
 */
package com.apress.prospring3.ch6.proxies;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

/**
 * @author clarence
 */
public class TestPointcut extends StaticMethodMatcherPointcut {

    public boolean matches(Method method, Class cls) {
        return ("advised".equals(method.getName()));
    }

}

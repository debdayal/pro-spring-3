/*
 * Created on Sep 30, 2011
 */
package com.apress.prospring3.ch6.security;

/**
 * @author clarence
 */
public class SecurityManager {

    private static ThreadLocal<UserInfo> threadLocal = new ThreadLocal<UserInfo>();

    public void login(String userName, String password) {
        // assumes that all credentials
        // are valid for a login
        threadLocal.set(new UserInfo(userName, password));
    }

    public void logout() {
        threadLocal.set(null);
    }

    public UserInfo getLoggedOnUser() {
        return threadLocal.get();
    }
}
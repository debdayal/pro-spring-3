/*
 * Created on Sep 30, 2011
 */
package com.apress.prospring3.ch6.security;


class UserInfo {
    private String userName;

    private String password;

    public UserInfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getUserName() {
        return userName;
    }
}
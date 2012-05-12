/*
 * Created on Sep 26, 2011
 */
package com.apress.prospring3.ch5.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author clarence
 */
public class MessageEvent extends ApplicationEvent {

    private String msg;
    
    public MessageEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }
    
    public String getMessage() {
        return msg;
    }
    
}
/*
 * Created on Sep 26, 2011
 */
package com.apress.prospring3.ch5.event;

import org.springframework.context.ApplicationListener;

/**
 * @author clarence
 */
public class MessageEventListener implements ApplicationListener<MessageEvent> {

	public void onApplicationEvent(MessageEvent event) {
		MessageEvent msgEvt = (MessageEvent) event;
		System.out.println("Received: " + msgEvt.getMessage());
	}

}

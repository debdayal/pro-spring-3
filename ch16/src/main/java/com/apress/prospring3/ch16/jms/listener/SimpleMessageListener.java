/**
 * Created on Nov 25, 2011
 */
package com.apress.prospring3.ch16.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Clarence
 *
 */
public class SimpleMessageListener implements MessageListener {

	private static final Logger logger = LoggerFactory.getLogger(SimpleMessageListener.class);
	
	public void onMessage(Message message) {

		TextMessage textMessage = (TextMessage) message;
		
		try {
			logger.info("Message received: " + textMessage.getText());
		} catch (JMSException ex) {
			logger.error("JMS error", ex);
		}
		
	}	
	
}

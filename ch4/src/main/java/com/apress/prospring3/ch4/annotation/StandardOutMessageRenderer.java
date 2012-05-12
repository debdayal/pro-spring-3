/**
 * Created on Sep 11, 2011
 */
package com.apress.prospring3.ch4.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apress.prospring3.ch4.MessageProvider;
import com.apress.prospring3.ch4.MessageRenderer;

/**
 * @author Clarence
 *
 */
@Service("messageRenderer")
public class StandardOutMessageRenderer implements MessageRenderer {

    private MessageProvider messageProvider = null;
	
	public void render() {
        if (messageProvider == null) {
            throw new RuntimeException(
                    "You must set the property messageProvider of class:"
                            + StandardOutMessageRenderer.class.getName());
        }

        System.out.println(messageProvider.getMessage());	
	}

	@Autowired
	//@Resource(name="messageProvider")  // Effect is the same as Autowired
	public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;		
	}

	public MessageProvider getMessageProvider() {
        return this.messageProvider;
	}
	
}

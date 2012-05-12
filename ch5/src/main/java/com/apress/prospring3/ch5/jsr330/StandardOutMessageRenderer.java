/**
 * Created on Sep 11, 2011
 */
package com.apress.prospring3.ch5.jsr330;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;


/**
 * @author Clarence
 *
 */
@Named("messageRenderer")
@Singleton
public class StandardOutMessageRenderer implements MessageRenderer {

	@Inject
	@Named("messageProvider")
    private MessageProvider messageProvider = null;
	
	public void render() {
        if (messageProvider == null) {
            throw new RuntimeException(
                    "You must set the property messageProvider of class:"
                            + StandardOutMessageRenderer.class.getName());
        }

        System.out.println(messageProvider.getMessage());	
	}

	public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;		
	}

	public MessageProvider getMessageProvider() {
        return this.messageProvider;
	}
	
}

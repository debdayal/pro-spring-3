/**
 * Created on Sep 11, 2011
 */
package com.apress.prospring3.ch5.javaconfig;


/**
 * @author Clarence
 *
 */
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

	public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;		
	}

	public MessageProvider getMessageProvider() {
        return this.messageProvider;
	}
	
}

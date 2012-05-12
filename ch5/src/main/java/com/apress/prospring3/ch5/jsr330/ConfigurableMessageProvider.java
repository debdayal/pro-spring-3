/**
 * Created on Sep 26, 2011
 */
package com.apress.prospring3.ch5.jsr330;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Clarence
 *
 */
@Named("messageProvider")
public class ConfigurableMessageProvider implements MessageProvider {

	private String message = "Default message";

	public ConfigurableMessageProvider() {
	}
	
	@Inject
	@Named("message")
	public ConfigurableMessageProvider(String message) {
		this.message = message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}	
	
}

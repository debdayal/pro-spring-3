/**
 * Created on Sep 26, 2011
 */
package com.apress.prospring3.ch5.javaconfig;

/**
 * @author Clarence
 *
 */
public class ConfigurableMessageProvider implements MessageProvider {

	private String message = "Default message";

	public ConfigurableMessageProvider() {
	}
	
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

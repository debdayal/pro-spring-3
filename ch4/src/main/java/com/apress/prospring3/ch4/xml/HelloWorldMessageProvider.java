/**
 * Created on Sep 11, 2011
 */
package com.apress.prospring3.ch4.xml;

import com.apress.prospring3.ch4.MessageProvider;

/**
 * @author Clarence
 *
 */
public class HelloWorldMessageProvider implements MessageProvider {

	public String getMessage() {
		
		return "Hello World!";
	}
	
}

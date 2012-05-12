/**
 * Created on Sep 11, 2011
 */
package com.apress.prospring3.ch4.annotation;

import org.springframework.stereotype.Service;

import com.apress.prospring3.ch4.MessageProvider;

/**
 * @author Clarence
 *
 */
//@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {

	public String getMessage() {
		
		return "Hello World!";
	}
	
}

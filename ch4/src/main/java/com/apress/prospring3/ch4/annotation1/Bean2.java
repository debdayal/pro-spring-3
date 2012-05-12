/**
 * Created on Sep 20, 2011
 */
package com.apress.prospring3.ch4.annotation1;

import org.springframework.stereotype.Service;

/**
 * @author Clarence
 *
 */
@Service("bean2")
public class Bean2 {

	public String sayHello() {
		return "I am bean2";
	}
	
}

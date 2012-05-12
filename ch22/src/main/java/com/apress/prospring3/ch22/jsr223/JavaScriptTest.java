/**
 * Created on Jan 16, 2012
 */
package com.apress.prospring3.ch22.jsr223;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author Clarence
 *
 */
public class JavaScriptTest {

	public static void main(String[] args) {

		ScriptEngineManager mgr = new ScriptEngineManager();
		
		ScriptEngine jsEngine = mgr.getEngineByName("JavaScript");		

		try {
			jsEngine.eval("print('Hello JavaScript in Java')");
		} catch (ScriptException ex) {
			ex.printStackTrace();
		}
	}

}

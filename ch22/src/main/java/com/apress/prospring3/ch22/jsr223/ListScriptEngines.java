/**
 * Created on Jan 16, 2012
 */
package com.apress.prospring3.ch22.jsr223;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

/**
 * @author Clarence
 *
 */
public class ListScriptEngines {

	public static void main(String[] args) {

		ScriptEngineManager mgr = new ScriptEngineManager();

		for (ScriptEngineFactory factory : mgr.getEngineFactories()) {
			String engineName= factory.getEngineName();
			String languageName = factory.getLanguageName();
			String version = factory.getLanguageVersion();
			System.out.println("Engine name: " + engineName + " Language: " + languageName + " version: " + version);
		}		

	}

}

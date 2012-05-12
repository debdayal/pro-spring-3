/**
 * Created on Sep 23, 2011
 */
package com.apress.prospring3.ch4.mi;

/**
 * @author Clarence
 *
 */
public class StandardLookupDemoBean implements DemoBean {

	private MyHelper myHelper;
	
	public void setMyHelper(MyHelper myHelper) {
		this.myHelper = myHelper; 
	}
	
	public MyHelper getMyHelper() {
		return this.myHelper; 
	}
	
	public void someOperation() {
		myHelper.doSomethingHelpful(); 
	}	
}

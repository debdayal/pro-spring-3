/**
 * Created on Sep 22, 2011
 */
package com.apress.prospring3.ch4;

/**
 * @author Clarence
 *
 */
public class Singleton {

    private static Singleton instance;
    
    static {
        instance = new Singleton();
    }
    
    public static Singleton getInstance() {
        return instance;
    }	
	
}

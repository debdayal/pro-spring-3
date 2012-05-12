/**
 * Created on Sep 20, 2011
 */
package com.apress.prospring3.ch4;

/**
 * @author Clarence
 *
 */
public class SetterInjection {

    private Dependency dependency;
    
    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }
}

/**
 * Created on Sep 21, 2011
 */
package com.apress.prospring3.ch4.annotation;

import org.springframework.stereotype.Service;

import com.apress.prospring3.ch4.Oracle;

/**
 * @author Clarence
 *
 */
@Service("injectRef")
public class InjectRef {

    private Oracle oracle;
    
    public void setOracle(Oracle oracle) {
        this.oracle = oracle;
        System.out.println(oracle.defineMeaningOfLife());
    }	
	
}

/**
 * Created on Oct 2, 2011
 */
package com.apress.prospring3.ch7.aopns;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author clarence
 *
 */
public class MyAdvice {

	// For simple joinpoint retrieval
    /*
	public void simpleBeforeAdvice(JoinPoint joinPoint) {
		System.out.println("Executing: " + joinPoint.getSignature().getDeclaringTypeName() + " " 
	        + joinPoint.getSignature().getName());
	}
	*/
	
	// For both joinpoint and argument retrieval
	public void simpleBeforeAdvice(JoinPoint joinPoint, int intValue) {
		
		if (intValue != 100) {
		    System.out.println("Executing: " + joinPoint.getSignature().getDeclaringTypeName() + " " 
	            + joinPoint.getSignature().getName()
	            + " argument: " + intValue);
		}
	}	
	
	public Object simpleAroundAdvice(ProceedingJoinPoint pjp, int intValue) throws Throwable {
		
	    System.out.println("Before execution: " + pjp.getSignature().getDeclaringTypeName() + " " 
	            + pjp.getSignature().getName()
	            + " argument: " + intValue);

	    Object retVal = pjp.proceed();
	    
	    System.out.println("After execution: " + pjp.getSignature().getDeclaringTypeName() + " " 
	            + pjp.getSignature().getName()
	            + " argument: " + intValue);	    
	    
	    return retVal;
	}
	
}

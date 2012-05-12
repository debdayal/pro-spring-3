/**
 * Created on Jan 4, 2012
 */
package com.apress.prospring3.ch19.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Clarence
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)	
public @interface DataSets {

	String setUpDataSet() default "";
	
}

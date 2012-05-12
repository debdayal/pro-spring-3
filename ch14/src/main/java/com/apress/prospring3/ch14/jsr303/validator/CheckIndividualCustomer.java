/**
 * Created on Nov 21, 2011
 */
package com.apress.prospring3.ch14.jsr303.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author Clarence
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy=IndividualCustomerValidator.class)
@Documented
public @interface CheckIndividualCustomer {

	String message() default "Individual customer should have gender and last name defined";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};		
	
}

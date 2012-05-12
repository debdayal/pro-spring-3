package com.apress.prospring3.ch23.batch.validator;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Batch validator to perform validation using Bean Validation API.
 * 
 * @author Clarence
 *
 */
public class BeanValidationValidator<Contact> implements Validator<Contact> {

	@Autowired
	private javax.validation.Validator validator;
	
	public void validate(Contact value) throws ValidationException {
		
		Set<ConstraintViolation<Contact>> violations = new HashSet<ConstraintViolation<Contact>>();
		violations = validator.validate(value);
		if(!violations.isEmpty()) { 
			throw new ValidationException("Validation failed for " + value + ": " + 
					violationsToString(violations)); 
		} 
	}
	
	private String violationsToString(Set<ConstraintViolation<Contact>> violations) {
		
		StringBuilder violationMessage = new StringBuilder();
		
		for (ConstraintViolation<Contact> violation: violations) {
			violationMessage.append(violation.getMessage() + "|");
		}
		
		return violationMessage.toString();
	}	
	
}

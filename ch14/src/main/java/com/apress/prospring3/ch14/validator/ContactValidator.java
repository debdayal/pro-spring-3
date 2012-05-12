/**
 * Created on Nov 21, 2011
 */
package com.apress.prospring3.ch14.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.apress.prospring3.ch14.domain.Contact;

/**
 * @author Clarence
 *
 */
@Component("contactValidator")
public class ContactValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Contact.class.equals(clazz);
	}

	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "firstName", "firstName.empty");
	}

}

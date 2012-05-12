/**
 * Created on Nov 21, 2011
 */
package com.apress.prospring3.ch14.validator;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.apress.prospring3.ch14.domain.Contact;

/**
 * @author Clarence
 *
 */
public class SpringValidatorSample {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring-validator-app-context.xml");
		ctx.refresh();		
		
		Contact contact = new Contact();
		contact.setFirstName(null);
		contact.setLastName("Ho");
		
		Validator contactValidator = ctx.getBean("contactValidator", Validator.class);
		
		BeanPropertyBindingResult result = new BeanPropertyBindingResult(contact, "Clarence");
		
		ValidationUtils.invokeValidator(contactValidator, contact, result);
		
		List<ObjectError> errors = result.getAllErrors();
		System.out.println("No of validation errors: " + errors.size());
		
		for (ObjectError error: errors) {
			System.out.println(error.getCode());
		}

	}

}

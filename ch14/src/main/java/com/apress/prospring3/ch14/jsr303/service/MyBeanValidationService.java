/**
 * Created on Nov 21, 2011
 */
package com.apress.prospring3.ch14.jsr303.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apress.prospring3.ch14.domain.Customer;

/**
 * @author Clarence
 *
 */
@Service("myBeanValidationService")
public class MyBeanValidationService {

	@Autowired
	private Validator validator;
	
	public Set<ConstraintViolation<Customer>> validateCustomer(Customer customer) {
		return validator.validate(customer);
	}
}

/**
 * Created on Nov 21, 2011
 */
package com.apress.prospring3.ch14.jsr303;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch14.domain.Customer;
import com.apress.prospring3.ch14.domain.CustomerType;
import com.apress.prospring3.ch14.jsr303.service.MyBeanValidationService;

/**
 * @author Clarence
 *
 */
public class Jsr303Sample {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:jsr303-app-context.xml");
		ctx.refresh();
		
		MyBeanValidationService myBeanValidationService = ctx.getBean("myBeanValidationService", MyBeanValidationService.class);
		
		Customer customer = new Customer();
		
		// Test basic constraints
		customer.setFirstName("C");
		customer.setLastName("Ho");
		customer.setCustomerType(null);
		customer.setGender(null);
		
		validateCustomer(customer, myBeanValidationService);	
		
		// Test custom constraints
		customer.setFirstName("Clarence");
		customer.setLastName("Ho");
		customer.setCustomerType(CustomerType.INDIVIDUAL);
		customer.setGender(null);
		
		validateCustomer(customer, myBeanValidationService);		
		
	}
	
	private static void validateCustomer(Customer customer, MyBeanValidationService myBeanValidationService) {
		
		Set<ConstraintViolation<Customer>> violations = new HashSet<ConstraintViolation<Customer>>();
		violations = myBeanValidationService.validateCustomer(customer);
		
		listViolations(violations);
	}
	
	private static void listViolations(Set<ConstraintViolation<Customer>> violations) {
		
		System.out.println("No. of violations: " + violations.size());
		
		for (ConstraintViolation<Customer> violation: violations) {
			System.out.println("Validation error for property: " + violation.getPropertyPath()
                               + " with value: " + violation.getInvalidValue()
			                   + " with error message: " + violation.getMessage());
		}
		
	}

}

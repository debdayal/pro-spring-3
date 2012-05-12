/**
 * Created on Oct 18, 2011
 */
package com.apress.prospring3.ch10.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.apress.prospring3.ch10.domain.Contact;

/**
 * @author Clarence
 *
 */
public interface ContactRepository extends CrudRepository<Contact, Long> {

	public List<Contact> findByFirstName(String firstName);
	
	public List<Contact> findByFirstNameAndLastName(String firstName, String lastName);	
	
}

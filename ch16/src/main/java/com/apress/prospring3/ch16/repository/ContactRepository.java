/**
 * Created on Nov 25, 2011
 */
package com.apress.prospring3.ch16.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.apress.prospring3.ch16.domain.Contact;

/**
 * @author Clarence
 *
 */
public interface ContactRepository extends CrudRepository<Contact, Long> {

	public List<Contact> findByFirstName(String firstName);
	
}

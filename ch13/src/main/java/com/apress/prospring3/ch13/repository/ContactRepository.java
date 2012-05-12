/**
 * Created on Oct 18, 2011
 */
package com.apress.prospring3.ch13.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.apress.prospring3.ch13.domain.Contact;

/**
 * @author Clarence
 *
 */
public interface ContactRepository extends CrudRepository<Contact, Long> {

	@Query("select count(c) from Contact c")
	public Long countAllContacts();
	
}

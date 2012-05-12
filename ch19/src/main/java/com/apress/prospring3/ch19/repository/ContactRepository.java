/**
 * Created on Dec 21, 2011
 */
package com.apress.prospring3.ch19.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.apress.prospring3.ch19.domain.Contact;

/**
 * @author Clarence
 *
 */
public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {

	public List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
	
}

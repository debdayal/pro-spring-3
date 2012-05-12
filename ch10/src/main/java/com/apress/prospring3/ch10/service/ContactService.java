/**
 * Created on Oct 17, 2011
 */
package com.apress.prospring3.ch10.service;

import java.util.List;

import com.apress.prospring3.ch10.domain.Contact;

/**
 * @author Clarence
 *
 */
public interface ContactService {

	// Find all contacts
	public List<Contact> findAll();
	
	// Find all contacts with telephone and hobbies	
	public List<Contact> findAllWithDetail();
	
	// Find a contact with details by id
	public Contact findById(Long id);
	
	// Insert or update a contact	
	public Contact save(Contact contact);
	
	// Delete a contact	
	public void delete(Contact contact);
	
	// Find all contacts by native query
	public List<Contact> findAllByNativeQuery();
	
	// Find contacts by criteria query
	public List<Contact> findByCriteriaQuery(String firstName, String lastName);
	
	// Find contacts by first name
	public List<Contact> findByFirstName(String firstName);
	
	// Find contacts by first name and last name
	public List<Contact> findByFirstNameAndLastName(String firstName, String lastName);	
}

/**
 * Created on Oct 12, 2011
 */
package com.apress.prospring3.ch9.dao;

import java.util.List;

import com.apress.prospring3.ch9.domain.Contact;

/**
 * @author Clarence
 *
 */
public interface ContactDao {

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
}

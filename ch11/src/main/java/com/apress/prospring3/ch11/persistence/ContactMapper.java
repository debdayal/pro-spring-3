/**
 * Created on Oct 24, 2011
 */
package com.apress.prospring3.ch11.persistence;

import java.util.List;

import com.apress.prospring3.ch11.domain.Contact;
import com.apress.prospring3.ch11.domain.SearchCriteria;

/**
 * @author Clarence
 *
 */
public interface ContactMapper {

	public List<Contact> findAll();
	
	public List<Contact> findAllWithDetail();
	
	public Contact findById(Long id);
	
	public List<Contact> findByFirstNameAndLastName(SearchCriteria criteria);	
	
	public void insertContact(Contact contact);
	
	public void updateContact(Contact contact);
	
	public void deleteContact(Long id);
	
}

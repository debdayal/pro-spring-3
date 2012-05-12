/**
 * Created on Oct 6, 2011
 */
package com.apress.prospring3.ch8.dao;

import java.util.List;

import com.apress.prospring3.ch8.domain.Contact;

/**
 * @author Clarence
 *
 */
public interface ContactDao {

	public List<Contact> findAll();
	
	public List<Contact> findAllWithDetail();
	
	public List<Contact> findByFirstName(String firstName);
	
	public String findFirstNameById(Long id);
	
	public String findLastNameById(Long id);
	
	public void insert(Contact contact);
	
	public void update(Contact contact);
	
	public void delete(Long contactId);
	
	public void insertWithDetail(Contact contact);
	
}

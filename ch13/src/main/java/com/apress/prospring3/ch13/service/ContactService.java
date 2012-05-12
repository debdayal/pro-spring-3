/**
 * Created on Nov 7, 2011
 */
package com.apress.prospring3.ch13.service;

import java.util.List;

import com.apress.prospring3.ch13.domain.Contact;

/**
 * @author Clarence
 *
 */
public interface ContactService {

	public List<Contact> findAll();
	
	public Contact findById(Long id);
	
	public Contact save(Contact contact);
	
	public long countAll();
}

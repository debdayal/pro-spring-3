/**
 * Created on Dec 21, 2011
 */
package com.apress.prospring3.ch19.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apress.prospring3.ch19.domain.Contact;
import com.apress.prospring3.ch19.repository.ContactRepository;
import com.apress.prospring3.ch19.service.ContactService;
import com.google.common.collect.Lists;

/**
 * @author Clarence
 *
 */
@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Transactional(readOnly=true)
	public List<Contact> findAll() {
		return Lists.newArrayList(contactRepository.findAll());
	}

	@Transactional(readOnly=true)
	public Contact findById(Long id) {
		return contactRepository.findOne(id);
	}

	@Transactional(readOnly=true)
	public Contact findByFirstNameAndLastName(String firstName, String lastName) {
		
		Contact contact = null;
		
		List<Contact> contacts = contactRepository.findByFirstNameAndLastName(firstName, lastName);
		if (contacts.size() > 0) contact = contacts.get(0);
		return contact;
	}

	public Contact save(Contact contact) {
		return contactRepository.save(contact);
	}

	@Transactional(readOnly=true)
	public Page<Contact> findAllByPage(Pageable pageable) {
		return contactRepository.findAll(pageable);
	}	
	
}

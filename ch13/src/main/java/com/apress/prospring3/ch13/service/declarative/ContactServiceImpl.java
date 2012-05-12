/**
 * Created on Nov 7, 2011
 */
package com.apress.prospring3.ch13.service.declarative;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.apress.prospring3.ch13.domain.Contact;
import com.apress.prospring3.ch13.repository.ContactRepository;
import com.apress.prospring3.ch13.service.ContactService;
import com.google.common.collect.Lists;

/**
 * @author Clarence
 *
 */
@Service("contactService")
@Repository
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;	
	
	public List<Contact> findAll() {
		return Lists.newArrayList(contactRepository.findAll());
	}

	public Contact findById(Long id) {
		return contactRepository.findOne(id);
	}

	public Contact save(Contact contact) {
		return contactRepository.save(contact);
	}

	public long countAll() {
		return contactRepository.countAllContacts();
	}

}

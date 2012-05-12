/**
 * Created on Nov 7, 2011
 */
package com.apress.prospring3.ch13.service.annotation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	
	public Contact save(Contact contact) {
		return contactRepository.save(contact);
	}

	@Transactional(propagation=Propagation.NEVER)
	//@Transactional(readOnly=true)
	public long countAll() {
		return contactRepository.countAllContacts();
	}

}

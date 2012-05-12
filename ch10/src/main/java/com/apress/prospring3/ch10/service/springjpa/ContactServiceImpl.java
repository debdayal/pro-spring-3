/**
 * Created on Oct 18, 2011
 */
package com.apress.prospring3.ch10.service.springjpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apress.prospring3.ch10.domain.Contact;
import com.apress.prospring3.ch10.repository.ContactRepository;
import com.apress.prospring3.ch10.service.ContactService;
import com.google.common.collect.Lists;

/**
 * @author Clarence
 *
 */
@Service("springJpaContactService")
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
	public List<Contact> findByFirstName(String firstName) {
		return contactRepository.findByFirstName(firstName);
	}

	@Transactional(readOnly=true)	
	public List<Contact> findByFirstNameAndLastName(String firstName,
			String lastName) {
		return contactRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	public List<Contact> findAllWithDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	public Contact findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Contact save(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Contact contact) {
		// TODO Auto-generated method stub
		
	}

	public List<Contact> findAllByNativeQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Contact> findByCriteriaQuery(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}

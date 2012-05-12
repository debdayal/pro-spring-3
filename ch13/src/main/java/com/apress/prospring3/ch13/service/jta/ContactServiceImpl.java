/**
 * Created on Nov 7, 2011
 */
package com.apress.prospring3.ch13.service.jta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apress.prospring3.ch13.domain.Contact;
import com.apress.prospring3.ch13.service.ContactService;

/**
 * @author Clarence
 *
 */
@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {
	
	@PersistenceContext(unitName="emfA")
	private EntityManager emA;
	
	@PersistenceContext(unitName="emfB")
	private EntityManager emB;	
	
	@Transactional(readOnly=true)
	public List<Contact> findAll() {
		return null;
	}

	@Transactional(readOnly=true)
	public Contact findById(Long id) {
		return null;
	}

	public Contact save(Contact contact) {
		Contact contactB = new Contact();
		contactB.setFirstName(contact.getFirstName());
		contactB.setLastName(contact.getLastName());
		if (contact.getId() == null) {
			emA.persist(contact);
			emB.persist(contactB);
			//throw new JpaSystemException(new PersistenceException());
		} else {
			emA.merge(contact);
			emB.merge(contact);
		}
		
		return contact;
	}

	public long countAll() {
		return 0;
	}

}

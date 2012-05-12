/**
 * Created on Nov 7, 2011
 */
package com.apress.prospring3.ch13.service.programmatic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.apress.prospring3.ch13.domain.Contact;
import com.apress.prospring3.ch13.service.ContactService;

/**
 * @author Clarence
 *
 */
@Service("contactService")
@Repository
public class ContactServiceImpl implements ContactService {

	@Autowired
	private TransactionTemplate transactionTemplate;
	
	@PersistenceContext
	private EntityManager em;	
	
	public List<Contact> findAll() {
		return null;
	}

	public Contact findById(Long id) {
		return null;
	}

	public Contact save(Contact contact) {
		return null;
	}

	public long countAll() {
		return transactionTemplate.execute(new TransactionCallback<Long>() {

			public Long doInTransaction(TransactionStatus transactionStatus) {
				return em.createNamedQuery("Contact.countAll", Long.class).getSingleResult();
			}
			
		});
	}

}

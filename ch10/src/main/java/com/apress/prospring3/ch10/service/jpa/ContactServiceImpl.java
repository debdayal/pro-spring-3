/**
 * Created on Oct 17, 2011
 */
package com.apress.prospring3.ch10.service.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apress.prospring3.ch10.domain.Contact;
import com.apress.prospring3.ch10.domain.Contact_;
import com.apress.prospring3.ch10.service.ContactService;

/**
 * @author Clarence
 *
 */
@Service("jpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

	private Log log = LogFactory.getLog(ContactServiceImpl.class);	
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional(readOnly=true)
	public List<Contact> findAll() {
		List<Contact> contacts = em.createNamedQuery("Contact.findAll", Contact.class).getResultList();
		return contacts;
	}

	@Transactional(readOnly=true)
	public List<Contact> findAllWithDetail() {
		List<Contact> contacts = em.createNamedQuery("Contact.findAllWithDetail", Contact.class).getResultList();
		return contacts;
	}

	@Transactional(readOnly=true)
	public Contact findById(Long id) {
		TypedQuery<Contact> query = em.createNamedQuery("Contact.findById", Contact.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	public Contact save(Contact contact) {
		if (contact.getId() == null) { // Insert Contact
			log.info("Inserting new contact");
			em.persist(contact);
		} else {                       // Update Contact
			em.merge(contact);
			log.info("Updating existing contact");
		}
		log.info("Contact saved with id: " + contact.getId());
		return contact;
	}

	public void delete(Contact contact) {
		Contact mergedContact = em.merge(contact);
		em.remove(mergedContact);
		log.info("Contact with id: " + contact.getId() + " deleted successfully");
	}
	
	final static String ALL_CONTACT_NATIVE_QUERY =
			"select id, first_name, last_name, birth_date, version from contact";

	@Transactional(readOnly=true)
	public List<Contact> findAllByNativeQuery() {

		//return em.createNativeQuery(ALL_CONTACT_NATIVE_QUERY, Contact.class).getResultList();
		return em.createNativeQuery(ALL_CONTACT_NATIVE_QUERY, "contactResult").getResultList();
	}

	@Transactional(readOnly=true)
	public List<Contact> findByCriteriaQuery(String firstName, String lastName) {

		log.info("Finding contact for firstName: " + firstName + " and lastName: " + lastName);
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Contact> criteriaQuery = cb.createQuery(Contact.class);
		Root<Contact> contactRoot = criteriaQuery.from(Contact.class);
		contactRoot.fetch(Contact_.contactTelDetails, JoinType.LEFT);
		contactRoot.fetch(Contact_.hobbies, JoinType.LEFT);

		criteriaQuery.select(contactRoot).distinct(true);
		
		Predicate criteria = cb.conjunction();
		
		// First Name
		if (firstName != null) {
			Predicate p = cb.equal(contactRoot.get(Contact_.firstName), firstName);
			criteria = cb.and(criteria, p);
		}
		
		// Last Name
		if (lastName != null) {
			Predicate p = cb.equal(contactRoot.get(Contact_.lastName), lastName);
			criteria = cb.and(criteria, p);
		}		
		
		criteriaQuery.where(criteria);
		List<Contact> result = em.createQuery(criteriaQuery).getResultList();
		return result;
		
	}

	public List<Contact> findByFirstName(String firstName) {
		// Not implemented
		return null;
	}

	public List<Contact> findByFirstNameAndLastName(String firstName,
			String lastName) {
		// Not implemented
		return null;
	}	
	
}

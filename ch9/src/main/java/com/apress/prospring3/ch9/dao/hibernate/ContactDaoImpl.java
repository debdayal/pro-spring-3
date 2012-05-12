/**
 * Created on Oct 12, 2011
 */
package com.apress.prospring3.ch9.dao.hibernate;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.apress.prospring3.ch9.dao.ContactDao;
import com.apress.prospring3.ch9.domain.Contact;

/**
 * @author Clarence
 *
 */
@Repository("contactDao")
@Transactional
public class ContactDaoImpl implements ContactDao {
	
	private Log log = LogFactory.getLog(ContactDaoImpl.class);
	
	private SessionFactory sessionFactory;	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly=true)
	public List<Contact> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Contact c").list();
	}

	public List<Contact> findAllWithDetail() {
		return sessionFactory.getCurrentSession().getNamedQuery("Contact.findAllWithDetail").list();
	}

	public Contact findById(Long id) {
		return (Contact) sessionFactory.getCurrentSession().
				getNamedQuery("Contact.findById").setParameter("id", id).uniqueResult();
	}

	public Contact save(Contact contact) {
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
		log.info("Contact saved with id: " + contact.getId());
		return contact;
	}

	public void delete(Contact contact) {
		sessionFactory.getCurrentSession().delete(contact);
		log.info("Contact deleted with id: " + contact.getId());
	}
	
}

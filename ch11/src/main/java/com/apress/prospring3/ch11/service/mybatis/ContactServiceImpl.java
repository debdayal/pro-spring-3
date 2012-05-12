/**
 * Created on Oct 24, 2011
 */
package com.apress.prospring3.ch11.service.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apress.prospring3.ch11.domain.Contact;
import com.apress.prospring3.ch11.domain.ContactHobbyDetail;
import com.apress.prospring3.ch11.domain.ContactTelDetail;
import com.apress.prospring3.ch11.domain.Hobby;
import com.apress.prospring3.ch11.domain.SearchCriteria;
import com.apress.prospring3.ch11.persistence.ContactHobbyDetailMapper;
import com.apress.prospring3.ch11.persistence.ContactMapper;
import com.apress.prospring3.ch11.persistence.ContactTelDetailMapper;
import com.apress.prospring3.ch11.service.ContactService;

/**
 * @author Clarence
 *
 */
@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

	private Log log = LogFactory.getLog(ContactServiceImpl.class);	
	
	@Autowired
	private ContactMapper contactMapper;
	
	@Autowired	
	private ContactTelDetailMapper contactTelDetailMapper;

	@Autowired
	private ContactHobbyDetailMapper contactHobbyDetailMapper;
	
	@Transactional(readOnly=true)
	public List<Contact> findAll() {
		List<Contact> contacts = contactMapper.findAll();
		return contacts;
	}

	@Transactional(readOnly=true)
	public List<Contact> findAllWithDetail() {
		List<Contact> contacts = contactMapper.findAllWithDetail();
		for (Contact contact: contacts) {
			populateContactTelDetail(contact);
		}		
		return contacts;
	}

	@Transactional(readOnly=true)
	public Contact findById(Long id) {
		Contact contact = contactMapper.findById(id);
		populateContactTelDetail(contact);
		return contact;
	}

	public Contact save(Contact contact) {
		if (contact.getId() == null) {
			insert(contact);
		} else {
			update(contact);
		}
		return contact;
	}

	private Contact insert(Contact contact) {
		contactMapper.insertContact(contact);
		Long contactId = contact.getId();
		ContactHobbyDetail contactHobbyDetail;
		if (contact.getContactTelDetails() != null) {
			for (ContactTelDetail contactTelDetail: contact.getContactTelDetails()) {
				contactTelDetail.setContact(contact);
				contactTelDetailMapper.insertContactTelDetail(contactTelDetail);
			}
		}
		if (contact.getHobbies() != null) {
			for (Hobby hobby: contact.getHobbies()) {
				contactHobbyDetail = new ContactHobbyDetail();
				contactHobbyDetail.setContactId(contactId);
				contactHobbyDetail.setHobbyId(hobby.getHobbyId());
				contactHobbyDetailMapper.insertContactHobbyDetail(contactHobbyDetail);
			}
		}		
		return contact;		
	}
	
	private Contact update(Contact contact) {
		contactMapper.updateContact(contact);
		Long contactId = contact.getId();
		ContactHobbyDetail contactHobbyDetail;
		
		// List storing orphan ids of contact tel details
		List<Long> ids = new ArrayList<Long>();
		
		// Retrieve existing telephones for contact
		List<ContactTelDetail> oldContactTelDetails = contactTelDetailMapper.selectTelDetailForContact(contactId);
	    for (ContactTelDetail contactTelDetail: oldContactTelDetails) {
	    	ids.add(contactTelDetail.getId());
	    }
		
		// Update telephone details
		if (contact.getContactTelDetails() != null) {
			for (ContactTelDetail contactTelDetail: contact.getContactTelDetails()) {
				if (contactTelDetail.getId() == null) {
					contactTelDetailMapper.insertContactTelDetail(contactTelDetail);
				} else {
					contactTelDetailMapper.updateContactTelDetail(contactTelDetail);
					ids.remove(contactTelDetail.getId());
				}
			}
			if (ids.size() > 0) {
				contactTelDetailMapper.deleteOrphanContactTelDetail(ids);
			}
		}
		
		// Update hobby details
		contactHobbyDetailMapper.deleteHobbyDetailForContact(contact.getId());
		if (contact.getHobbies() != null) {
			for (Hobby hobby: contact.getHobbies()) {
				contactHobbyDetail = new ContactHobbyDetail();
				contactHobbyDetail.setContactId(contactId);
				contactHobbyDetail.setHobbyId(hobby.getHobbyId());				
				contactHobbyDetailMapper.insertContactHobbyDetail(contactHobbyDetail);
			}
		}
		
		return contact;
	}
	
	public void delete(Contact contact) {
		Long contactId = contact.getId();
		contactTelDetailMapper.deleteTelDetailForContact(contactId);
		contactHobbyDetailMapper.deleteHobbyDetailForContact(contactId);
		contactMapper.deleteContact(contactId);		
	}

	@Transactional(readOnly=true)
	public List<Contact> findByFirstNameAndLastName(String firstName,
			String lastName) {
		log.info("Finding contact with first name: " + firstName + " and last name: " + lastName);
		Contact contact = new Contact();
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		SearchCriteria criteria = new SearchCriteria();
		criteria.setFirstName(firstName);
		criteria.setLastName(lastName);	
		
		List<Contact> contacts = contactMapper.findByFirstNameAndLastName(criteria);
		for (Contact contactTemp: contacts) {
			populateContactTelDetail(contactTemp);
		}				
		
		return contacts;
	}
	
	private void populateContactTelDetail(Contact contact) {
		if (contact.getContactTelDetails() != null) {
			for (ContactTelDetail contactTelDetail: contact.getContactTelDetails()) {
				contactTelDetail.setContact(contact);
			}
		}
	}

}

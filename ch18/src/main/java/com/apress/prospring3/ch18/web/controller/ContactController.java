/**
 * Created on Dec 29, 2011
 */
package com.apress.prospring3.ch18.web.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.primefaces.model.DualListModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

import com.apress.prospring3.ch18.domain.Contact;
import com.apress.prospring3.ch18.domain.Hobby;
import com.apress.prospring3.ch18.service.ContactService;
import com.apress.prospring3.ch18.service.HobbyService;
import com.apress.prospring3.ch18.web.view.ContactBean;
import com.apress.prospring3.ch18.web.view.ContactListBean;

/**
 * @author Clarence
 *
 */
@Component("contactController")
public class ContactController {

	private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

	@Autowired
	private ContactService contactService;
	
	@Autowired
	private HobbyService hobbyService;	
	
	public ContactListBean newContactListBean() {
		
		ContactListBean contactListBean = new ContactListBean();
		
		contactListBean.setContacts(contactService.findAll());
		
		return contactListBean;
		
	}
	
	public Contact showContact(RequestContext context) {
		
		Long id = context.getRequestScope().getLong("contactId");
		
		logger.info("Selected contact id: {}", id);
		
		return contactService.findByIdWithDetail(id);
		
	}
	
	public ContactBean newContactBean() {
		
		logger.info("Creating new contact bean");
		ContactBean contactBean = new ContactBean();
		
		Contact contact = new Contact();
		contactBean.setContact(contact);
		
        List<Hobby> hobbiesSource = new ArrayList<Hobby>();
        List<Hobby> hobbiesTarget = new ArrayList<Hobby>();
       
        for (Hobby hobby: hobbyService.findAll()) {
        	hobbiesSource.add(hobby);
        }
		
        DualListModel<Hobby> hobbies = new DualListModel<Hobby>(hobbiesSource, hobbiesTarget);  
        
        contactBean.setHobbies(hobbies);
		
		return contactBean;
		
	}
	
	public void saveContact(RequestContext context) {
		
		// Retrieve contact bean
		ContactBean contactBean = (ContactBean) context.getFlowScope().get("contactBean");
		Contact contact = contactBean.getContact();
		
		Set<Hobby> hobbies = new HashSet<Hobby>(contactBean.getHobbies().getTarget());
		
		contact.setHobbies(hobbies);
		
		contactService.save(contact);
		
		logger.info("Contact {} {} saved successfully", contact.getFirstName(), contact.getLastName());
		
		context.getMessageContext().addMessage(new MessageBuilder().info().code("message_contact_save_success").build());
		
	}	
	
}

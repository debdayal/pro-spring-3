/**
 * Created on Nov 25, 2011
 */
package com.apress.prospring3.ch16.web.restful.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apress.prospring3.ch16.domain.Contact;
import com.apress.prospring3.ch16.domain.Contacts;
import com.apress.prospring3.ch16.service.ContactService;

/**
 * @author Clarence
 *
 */
@Controller
@RequestMapping(value="/contact")
public class ContactController {

	final Logger logger = LoggerFactory.getLogger(ContactController.class);
	
	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/listdata", method = RequestMethod.GET)
	@ResponseBody
	public Contacts listData() {
		return new Contacts(contactService.findAll());
	}	

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Contact findContactById(@PathVariable Long id) {		
		return contactService.findById(id);
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	@ResponseBody
	public Contact create(@RequestBody @Valid Contact contact) {
		logger.info("Creating contact: " + contact);
		contactService.save(contact);
		logger.info("Contact created successfully with info: " + contact);
		return contact;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@ResponseBody
	public void update(@RequestBody Contact contact, @PathVariable Long id) {
		logger.info("Updating contact: " + contact);
		contactService.save(contact);
		logger.info("Contact updated successfully with info: " + contact);
		//return contact;
	}	

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@ResponseBody
	public void delete(@PathVariable Long id) {
		logger.info("Deleting contact with id: " + id);
		Contact contact = contactService.findById(id);
		contactService.delete(contact);
		logger.info("Contact deleted successfully");
	}	
	
}

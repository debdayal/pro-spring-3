package com.apress.prospring3.ch19.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.context.MessageSource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.apress.prospring3.ch19.domain.Contact;
import com.apress.prospring3.ch19.service.ContactService;

/**
 * @author Clarence
 *
 */
public class ContactControllerTest extends AbstractControllerTest {
	
	private final List<Contact> contacts = new ArrayList<Contact>();
	
	private ContactService contactService;
	
	private MessageSource messageSource;
	
	@Before
	public void initContacts() {
		// Initialize list of contacts for mocked ContactService
		Contact contact = new Contact();
		contact.setId(1l);
		contact.setFirstName("Clarence");
		contact.setLastName("Ho");
		contacts.add(contact);
	}

	@Test
	public void testList() throws Exception {

		contactService = mock(ContactService.class);
		when(contactService.findAll()).thenReturn(contacts);
		
		ContactController contactController = new ContactController();
		
		ReflectionTestUtils.setField(contactController, "contactService", contactService);
		
		ExtendedModelMap uiModel = new ExtendedModelMap();

		String result = contactController.list(uiModel);

		assertNotNull(result);
		assertEquals(result, "contacts/list");

		List<Contact> modelContacts = (List<Contact>) uiModel.get("contacts");
		
		assertEquals(1, modelContacts.size());
	}
	
	@Test
	public void testCreate() {
		
		final Contact newContact = new Contact();
		newContact.setId(999l);
		newContact.setFirstName("Rod");
		newContact.setFirstName("Johnson");	
		
		contactService = mock(ContactService.class);
		when(contactService.save(newContact)).thenAnswer( new Answer<Contact>() {
			public Contact answer(InvocationOnMock invocation) throws Throwable {
				contacts.add(newContact);
				return newContact;
			}		
		});
		messageSource = mock(MessageSource.class);
		when(messageSource.getMessage("contact_save_success", new Object[]{}, Locale.ENGLISH)).thenReturn("success");
		
		ContactController contactController = new ContactController();
		ReflectionTestUtils.setField(contactController, "contactService", contactService);
		ReflectionTestUtils.setField(contactController, "messageSource", messageSource);
		
		BindingResult bindingResult = new BeanPropertyBindingResult(newContact, "contact");
		ExtendedModelMap uiModel = new ExtendedModelMap();
		HttpServletRequest httpServletRequest = new MockHttpServletRequest(); 
		RedirectAttributes redirectAttributes = new RedirectAttributesModelMap();
		Locale locale = Locale.ENGLISH;
		
		String result = contactController.create(newContact, bindingResult, uiModel, httpServletRequest, redirectAttributes, locale, null);

		assertNotNull(result);
		assertEquals("redirect:/contacts/999", result);
		assertEquals(2, contacts.size());
	}		
}
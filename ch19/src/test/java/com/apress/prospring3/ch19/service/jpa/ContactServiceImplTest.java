package com.apress.prospring3.ch19.service.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.apress.prospring3.ch19.domain.Contact;
import com.apress.prospring3.ch19.service.ContactService;
import com.apress.prospring3.ch19.test.annotation.DataSets;

/**
 * @author Clarence
 *
 */
public class ContactServiceImplTest extends AbstractServiceImplTest {

	@Autowired
	ContactService customerService;
	
	@DataSets(setUpDataSet="/com/apress/prospring3/ch19/service/jpa/ContactServiceImplTest.xls")
	@Test
	public void testFindAll()
		throws Exception {

		List<Contact> result = customerService.findAll();

		assertNotNull(result);
		assertEquals(1, result.size());
	}
	
	@DataSets(setUpDataSet="/com/apress/prospring3/ch19/service/jpa/ContactServiceImplTest.xls")
	@Test
	public void testFindByFirstNameAndLastName_1()
		throws Exception {

		Contact result = customerService.findByFirstNameAndLastName("Clarence", "Ho");

		assertNotNull(result);
	}
	
	@DataSets(setUpDataSet="/com/apress/prospring3/ch19/service/jpa/ContactServiceImplTest.xls")
	@Test
	public void testFindByFirstNameAndLastName_2()
		throws Exception {

		Contact result = customerService.findByFirstNameAndLastName("Peter", "Chan");

		assertNull(result);
	}	
	
	@Test
	public void testAddContact()
		throws Exception {

		// Clear all existing data in Contact table
		deleteFromTables("CONTACT");
		
		Contact contact = new Contact();
		contact.setFirstName("Rod");
		contact.setLastName("Johnson");

		contact = customerService.save(contact);
		em.flush();
		
		List<Contact> contacts = customerService.findAll();
		assertEquals(1, contacts.size());
		
	}

	@Test(expected=ConstraintViolationException.class)
	public void testAddContactWithJSR303Error()
		throws Exception {

		// Clear all existing data in Contact table
		deleteFromTables("CONTACT");
		
		Contact contact = new Contact();

		contact = customerService.save(contact);
		em.flush();
		
		List<Contact> contacts = customerService.findAll();
		assertEquals(0, contacts.size());
		
	}		

}
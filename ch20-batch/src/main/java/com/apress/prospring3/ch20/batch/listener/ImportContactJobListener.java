/**
 * Created on Jan 10, 2012
 */
package com.apress.prospring3.ch20.batch.listener;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.apress.prospring3.ch20.domain.Contact;
import com.apress.prospring3.ch20.service.ContactService;

/**
 * @author Clarence
 *
 */
public class ImportContactJobListener implements JobExecutionListener {

	private static final Logger logger = LoggerFactory.getLogger(ImportContactJobListener.class);
	
	@Autowired
	private ContactService contactService;
	
	@Override
	public void afterJob(JobExecution arg0) {
		List<Contact> contacts = contactService.findAll();
		for (Contact contact: contacts) {
			logger.info("Contact: {}", contact);
		}
	}

	@Override
	public void beforeJob(JobExecution arg0) {		
	}

}

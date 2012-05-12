/**
 * Created on Oct 18, 2011
 */
package com.apress.prospring3.ch10.service;

import java.util.List;

import com.apress.prospring3.ch10.domain.ContactAudit;

/**
 * @author Clarence
 *
 */
public interface ContactAuditService {

	public List<ContactAudit> findAll();
	
	public ContactAudit findById(Long id);
	
	public ContactAudit save(ContactAudit contact);	
	
	public ContactAudit findAuditByRevision(Long id, int revision);
	
}

/**
 * Created on Oct 17, 2011
 */
package com.apress.prospring3.ch10.service;

import java.util.List;

import com.apress.prospring3.ch10.domain.ContactSummary;

/**
 * @author Clarence
 *
 */
public interface ContactSummaryService {

	public List<ContactSummary> findAll();
	
}

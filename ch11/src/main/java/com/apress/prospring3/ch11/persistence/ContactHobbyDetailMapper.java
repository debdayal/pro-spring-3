/**
 * Created on Oct 24, 2011
 */
package com.apress.prospring3.ch11.persistence;

import com.apress.prospring3.ch11.domain.ContactHobbyDetail;

/**
 * @author Clarence
 *
 */
public interface ContactHobbyDetailMapper {

	public void insertContactHobbyDetail(ContactHobbyDetail contactHobbyDetail);
	
	public void deleteHobbyDetailForContact(Long contactId);	
	
}

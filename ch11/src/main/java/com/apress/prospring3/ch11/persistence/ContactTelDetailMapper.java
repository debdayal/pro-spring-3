/**
 * Created on Oct 24, 2011
 */
package com.apress.prospring3.ch11.persistence;

import java.util.List;

import com.apress.prospring3.ch11.domain.ContactTelDetail;

/**
 * @author Clarence
 *
 */
public interface ContactTelDetailMapper {

	public List<ContactTelDetail> selectTelDetailForContact(Long contactId);
	
	public void insertContactTelDetail(ContactTelDetail contactTelDetail);
	
	public void updateContactTelDetail(ContactTelDetail contactTelDetail);
	
	public void deleteOrphanContactTelDetail(List<Long> ids);
	
	public void deleteTelDetailForContact(Long contactId);	
	
}

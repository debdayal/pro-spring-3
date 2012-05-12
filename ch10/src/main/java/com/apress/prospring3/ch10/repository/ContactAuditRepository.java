/**
 * Created on Oct 18, 2011
 */
package com.apress.prospring3.ch10.repository;

import org.springframework.data.repository.CrudRepository;

import com.apress.prospring3.ch10.domain.ContactAudit;

/**
 * @author Clarence
 *
 */
public interface ContactAuditRepository extends CrudRepository<ContactAudit, Long> {

}

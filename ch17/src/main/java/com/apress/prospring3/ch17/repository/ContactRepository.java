/**
 * Created on Dec 21, 2011
 */
package com.apress.prospring3.ch17.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.apress.prospring3.ch17.domain.Contact;

/**
 * @author Clarence
 *
 */
public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {

}

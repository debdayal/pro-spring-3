/**
 * Created on Dec 21, 2011
 */
package com.apress.prospring3.ch23.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.apress.prospring3.ch23.domain.Contact;

/**
 * @author Clarence
 *
 */
public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {

}
